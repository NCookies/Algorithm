package Study.Chapter08_탐욕알고리즘.P11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int coin = 0;
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (coin + arr[i] <= k) {
                coin += arr[i];
                cnt++;
            }

            if (coin == k) {
                System.out.println(cnt);
                return;
            }
        }
    }
}
