package Study.Chapter04_퀵정렬.P2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, n - 1);

        for (int i = 0 ; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(arr, lo, hi);

        quickSort(arr, lo, pivot);
        quickSort(arr, pivot + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        // 피벗으로 중간값 선택
        // int 값의 오버플로우를 대비하여 다음과 같이 수식을 구성함
        int pivot = arr[lo + ((hi - lo) / 2)];
        lo--; hi++;

        while (lo <= hi) {
            do {
                lo++;
            } while (arr[lo] < pivot);

            do {
                hi--;
            } while (arr[hi] > pivot && lo <= hi);

            if (lo < hi) {
                swap(arr, lo, hi);
            } else {
                break;
            }
        }

        return hi;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
