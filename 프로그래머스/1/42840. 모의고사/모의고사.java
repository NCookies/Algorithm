import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[][] randoms = {
            { 1, 2, 3, 4, 5 },
            { 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5 },
            { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
        };
        int[] cnt = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < randoms.length; j++) {
                if (answers[i] == randoms[j][i % randoms[j].length]) {
                    cnt[j] += 1;
                }             
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        for (int k = 0; k < 3; k++) {
            if (cnt[k] == max) {
                answer.add(k + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}