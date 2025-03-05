class Solution {
    public int[] solution(long n) {
        char[] digits = Long.toString(n).toCharArray();
        int[] answer = new int[digits.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = digits[answer.length - i - 1] - 48;
        }
        
        return answer;
    }
}