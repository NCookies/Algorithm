class Solution {
    public int solution(int num1, int num2) {
        double div = (double) num1 / (double) num2;
        int answer = (int) (div * 1000);
        return answer;
    }
}