package Study.Chapter06_깊이우선탐색.여행경로;

import java.util.*;

public class Main {
    static boolean[] used;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };
//        String[][] tickets = {
//                {"AAA", "BBB"},
//                {"AAA", "CCC"},
//                {"CCC", "AAA"}
//        };
//        String[][] tickets = {
//                {"ICN", "D"},
//                {"D", "ICN"},
//                {"ICN", "B"}
//        };

        solution(tickets);
    }

    static public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];

        // 탐색 수행
        dfs(tickets, "ICN", "ICN", 0);

        // 사전 순으로 경로 정렬
        Collections.sort(result);

        // 여러 경로를 사전 순으로 정렬했으므로 첫 번째 경로가 정답
        return result.get(0).split(" ");
    }

    static private void dfs(String[][] tickets, String departure, String route, int depth) {
        // 탈출 조건 : 비행기 티켓을 모두 소모한 경우
        if (depth == tickets.length) {
            // 완성된 경로 추가
            result.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 아직 사용하지 않고 출발지가 동일한 티켓
            if (!used[i] && tickets[i][0].equals(departure)) {
                used[i] = true;
                dfs(tickets, tickets[i][1], route + " " + tickets[i][1], depth + 1);
                used[i] = false;
            }
        }
    }
}
