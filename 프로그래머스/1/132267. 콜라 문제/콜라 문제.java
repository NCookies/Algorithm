class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (true) {
            int newCola = n / a * b;
            answer += newCola;
            n = newCola + (n % a);
            
            if (n / a < 1) {
                break;
            }
        }
        
        return answer;
    }
}