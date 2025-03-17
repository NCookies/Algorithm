import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int l = s.length();
        int[] answer = new int[l];
        int[] check = new int[27];
        
        Arrays.fill(check, -1);
        
        for (int i = 0; i < l; i++) {
            int alphabetIndex = s.charAt(i) - 'a';
            if (check[alphabetIndex] != -1) {
                // 가장 가까운 글자 위치 저장 및 갱신
                answer[i] = i - check[alphabetIndex];
            } else {
                // 처음 나왔을 때
                answer[i] = -1;
            }
            check[alphabetIndex] = i;
        }
        
        return answer;
    }
}