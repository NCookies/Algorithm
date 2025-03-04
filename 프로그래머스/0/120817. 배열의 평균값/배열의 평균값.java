class Solution {
    public double solution(int[] numbers) {
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double answer = sum / numbers.length;
        return answer;
    }
}