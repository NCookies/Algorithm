package Study.Chapter06_깊이우선탐색.여행경로;

import java.util.*;

public class Main {
    static String[] answer;
    static boolean[] used;
    static Map<String, List<String>> map;

    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };
        solution(tickets);
    }

    static public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        used = new boolean[tickets.length];

        map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }

        dfs("ICN", 0);

        return answer;
    }

    static private void dfs(String departure, int depth) {
        List<String> arrivals = map.get(departure);
        if (arrivals.isEmpty()) {
            answer[depth] = departure;
            return;
        }
        arrivals.sort(String::compareTo);

        for (int i = 0; i < arrivals.size(); i++) {
            answer[depth] = departure;
            arrivals.ge
        }

        for (String arrival : arrivals) {
            answer[depth] = departure;
            arrivals.remove(arrival);
            dfs(arrival, depth + 1);
        }
    }
}
