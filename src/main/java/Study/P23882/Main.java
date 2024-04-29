package Study.P23882;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 각 숫자가 몇 번째 인덱스에 있는지 저장하고 있는 배열
        int[] idxArr = new int[n + 1];

        // 수열 A를 저장하고 있는 배열
        int[] numArr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());;
            idxArr[num] = i;
            numArr[i] = num;
        }

        int times = 0;      // 교환 횟수

        // selection sort
        for (int i = n; i > 0; i--) {
            // i 위치의 값이 max가 아닌 경우
            if (numArr[i] != i) {
                int maxIndex = idxArr[i];

                int tmp = idxArr[numArr[i]];
                idxArr[numArr[i]] = idxArr[i];
                idxArr[i] = tmp;

                tmp = numArr[maxIndex];
                numArr[maxIndex] = numArr[i];
                numArr[i] = tmp;

                times++;

                if (times >= k) {
                    for (int p = 1; p <= n; p++) {
                        sb.append(numArr[p]).append(' ');
                    }
                    System.out.println(sb);
                    return;
                }

            }
        }

        System.out.println(-1);
    }
}
//
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        int[] arr = new int[n];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int times = 0;      // 교환 횟수
//
//        // selection sort
//        for (int i = n - 1; i > 0; i--) {
//            int maxIndex = i;
//            for (int j = 0; j <= i; j++) {
//                if (arr[j] > arr[maxIndex]) {
//                    maxIndex = j;
//                }
//            }
//
//            if (i != maxIndex) {
//                int tmp = arr[i];
//                arr[i] = arr[maxIndex];
//                arr[maxIndex] = tmp;
//
//                // 교환 발생했을 때에만 카운트
//                times++;
//
//                if (times >= k) {
//                    for (int p = 0; p < n; p++) {
//                        sb.append(arr[p]).append(' ');
//                    }
//                    System.out.println(sb);
//                    return;
//                }
//            }
//        }
//
//        System.out.println(-1);
//    }
//}
