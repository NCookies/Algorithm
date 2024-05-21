package Study.Chapter06_너비우선탐색.단어변환;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

    static public int solution(String begin, String target, String[] words) {
        // 방문 여부 및 변환 횟수 저장
        Map<String, Integer> visitedMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        // 초기 설정
        queue.offer(begin);
        visitedMap.put(begin, 1);

        while (!queue.isEmpty()) {
            String poll = queue.poll();

            for (String now : words) {
                int diff = 0;

                // 이미 변환했던 단어라면 탐색하지 않음
                if (visitedMap.containsKey(now)) {
                    continue;
                }

                // 단어 비교. 알파벳이 하나 다를 때마다 diff++
                for (int j = 0; j < poll.length(); j++) {
                    if (poll.charAt(j) != now.charAt(j)) {
                        diff++;
                    }
                }

                // 알파벳 하나만 다를 경우
                if (diff == 1) {
                    // 목표 단어와 같으면 변환 횟수 반환
                    if (now.equals(target)) {
                        return visitedMap.get(poll);
                    }
                    visitedMap.put(now, visitedMap.get(poll) + 1);
                    queue.offer(now);
                }
            }
        }

        // 끝까지 못 찾으면 0 반환
        return 0;
    }
}
