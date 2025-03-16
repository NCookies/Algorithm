import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] numbers) {
        boolean[] check = new boolean[201];
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int add = numbers[i] + numbers[j];
                check[add] = true;
            }
        }
        
        return IntStream.range(0, check.length)
                        .filter(i -> check[i])
                        .toArray();
    }
}