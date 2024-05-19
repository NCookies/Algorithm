package Study.Chapter04_퀵정렬.P2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.shuffle(list);

        quickSort(list, 0, n - 1);

        for (int i = 0 ; i < n; i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static void quickSort(ArrayList<Integer> arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(arr, lo, hi);

        quickSort(arr, lo, pivot);
        quickSort(arr, pivot + 1, hi);
    }

    private static int partition(ArrayList<Integer> arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        // 피벗으로 중간값 선택
        // int 값의 오버플로우를 대비하여 다음과 같이 수식을 구성함
        int pivot = arr.get(mid);
        lo--; hi++;

        while (lo <= hi) {
            do {
                lo++;
            } while (arr.get(lo) < pivot);

            do {
                hi--;
            } while (arr.get(hi) > pivot && lo <= hi);

            if (lo < hi) {
                swap(arr, lo, hi);
            } else {
                break;
            }
        }

        return hi;
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}
