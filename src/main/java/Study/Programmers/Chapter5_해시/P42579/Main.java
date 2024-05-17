package Study.Programmers.Chapter5_해시.P42579;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 2500, 150, 800, 2500});
    }

    static public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCntMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> songPlayMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            int oldScore = genrePlayCntMap.getOrDefault(genres[i], 0);
            genrePlayCntMap.put(genres[i], oldScore + plays[i]);       // 장르별 재생수 카운트

            songPlayMap.computeIfAbsent(genres[i], k -> new HashMap<>()).put(i, plays[i]);
        }

        // 노래들의 재생수가 가장 많은 장르부터 내림차순 정렬
        ArrayList<String> keySet = new ArrayList<>(genrePlayCntMap.keySet());
        keySet.sort(((o1, o2) -> genrePlayCntMap.get(o2).compareTo(genrePlayCntMap.get(o1))));

        List<Integer> answerList = new ArrayList<>();
        int[] answer = new int[keySet.size() * 2];
        int answerIndex = 0;
        for (String s : keySet) {
            // 인기 장르 순으로 추출
            Map<Integer, Integer> map = songPlayMap.get(s);

            ArrayList<Integer> integers = new ArrayList<>(map.keySet());
            integers.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1))));
//            answer[answerIndex++] = integers.get(0);
//            answer[answerIndex++] = integers.get(1);
            answerList.add(integers.get(0));
            answerList.add(integers.get(1));
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
