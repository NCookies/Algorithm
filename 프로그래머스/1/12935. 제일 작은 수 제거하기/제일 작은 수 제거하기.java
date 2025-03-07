import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{ -1 };
        }

        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minIndex = i;
                minValue = arr[i];
            }
        }

        int[] answer = new int[arr.length - 1];

        // System.arraycopy(원본, 원본 시작 인덱스, 대상 배열, 대상 시작 인덱스, 복사 길이)
        System.arraycopy(arr, 0, answer, 0, minIndex);
        System.arraycopy(arr, minIndex + 1, answer, minIndex, arr.length - minIndex - 1);

        return answer;
    }
}