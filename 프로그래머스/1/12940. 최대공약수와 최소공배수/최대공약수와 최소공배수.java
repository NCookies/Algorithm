class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int a = Math.min(n, m);
        int b = Math.max(n, m);
        
        int min = 0;
        int max = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                min = i;
            }
        }
        max = a * b / min;
        
        answer[0] = min;
        answer[1] = max;
        
        return answer;
    }
}