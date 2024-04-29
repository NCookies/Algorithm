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

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int times = 0;      // 교환 횟수

        // selection sort
        for (int i = n - 1; i > 0; i--) {
            int maxIndex = i;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (i != maxIndex) {
                int tmp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = tmp;

                // 교환 발생했을 때에만 카운트
                times++;

                if (times >= k) {
                    for (int p = 0; p < n; p++) {
                        sb.append(arr[p]).append(' ');
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
