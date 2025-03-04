class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 2로 나눴을 때 몫이 짝수일 때
        if ((n / 2) % 2 == 0) {
            answer = (n + 2) * (n / 4);
        } else {
            answer = (n + 2) * (n / 4) + (n / 2 + 1);
        }
        
        return answer;
    }
}