class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            answer += isDivisorCountEven(i) ? i : -i;
        }
        
        return answer;
    }
    
    // n의 제곱근이 정수면 약수가 홀수개, 아니면 짝수개
    boolean isDivisorCountEven(int n) {
        double sqrt = Math.sqrt(n);
        return sqrt != (double) ((int) sqrt);
    }
}