package Study.Chapter04_퀵정렬.P24092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arrB;

    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arrA = new int[n];
        arrB = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        if (compare(arrA)) {
            return;
        }

        quickSort(arrA, 0, n - 1);

        if (!flag) {
            System.out.println(0);
        }
    }

    static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(a, lo, hi);
            if (pivot == -1) {
                return;
            }

            quickSort(a, lo, pivot - 1);
            quickSort(a, pivot + 1, hi);
        }
    }

    static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                if (swap(a, ++i, j)) {
                    if (compare(a)) {
                        return -1;
                    }
                }
            }
        }

        if (i + 1 != hi) {
            if (swap(a, i + 1, hi)) {
                if (compare(a)) {
                    return -1;
                }
            }
        }

        return i + 1;
    }

    static boolean swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        // 스왑한 데이터만을 비교
        return (a[i] == arrB[i]) && (a[j] == arrB[j]);
    }

    static boolean compare(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != arrB[i]) {
                return false;
            }
        }
        flag = true;
        System.out.println(1);

        return true;
    }
}
