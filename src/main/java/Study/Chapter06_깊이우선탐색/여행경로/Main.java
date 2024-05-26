package Study.Chapter06_깊이우선탐색.여행경로;

import java.util.*;

public class Main {
    static String[] answer;
    static boolean[] used;
    static Map<String, List<String>> map;

    public static void main(String[] args) {
//        String[][] tickets = {
//                {"ICN", "SFO"},
//                {"ICN", "ATL"},
//                {"SFO", "ATL"},
//                {"ATL", "ICN"},
//                {"ATL", "SFO"}
//        };
//        String[][] tickets = {
//                {"AAA", "BBB"},
//                {"AAA", "CCC"},
//                {"CCC", "AAA"}
//        };
        String[][] tickets = {
                {"ICN", "D"},
                {"D", "ICN"},
                {"ICN", "B"}
        };

        solution(tickets);
    }

    static public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        used = new boolean[tickets.length];

        Arrays.sort(tickets, Comparator.comparing(ticket -> ticket[1]));

        dfs(tickets, "ICN", 0);

        return answer;
    }

    static private void dfs(String[][] tickets, String departure, int depth) {
        if (depth == tickets.length) {
            answer[depth] = departure;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 아직 사용하지 않고 출발지가 동일한 티켓
            if (!used[i] && tickets[i][0].equals(departure)) {
                used[i] = true;
                answer[depth] = departure;
                dfs(tickets, tickets[i][1], depth + 1);

                used[i] = false;
            }
        }
    }
}
