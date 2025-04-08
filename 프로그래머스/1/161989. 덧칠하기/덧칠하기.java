class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int idx = 0;    // 현재 위치
        
        for (int i = 0; i < section.length; i++) {
            if (idx <= section[i]) {
                idx = section[i] + m;
                answer++;
            }
        }
        
        return answer;
    }
}