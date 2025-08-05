class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int attackPower = getDivisorCount(i);
            answer += attackPower > limit ? power : attackPower;
        }
        
        return answer;
    }
    
    public int getDivisorCount(int num) {
        int cnt = 0;
        
        for (int n = 1; n <= Math.sqrt(num); n++) {
            if (n == Math.sqrt(num)) {
                cnt += 1;
            } else if (num % n == 0) {
                cnt += 2;
            }
            
        }
            
        return cnt;
    }
}