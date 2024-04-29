package Study.P23883;

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
                if (++times >= k) {
                    sb.append(numArr[i]).append(" ").append(i);
                    System.out.println(sb);
                    return;
                }

                idxArr[numArr[i]] = idxArr[i];
                numArr[idxArr[i]] = numArr[i];
            }
        }

        System.out.println(-1);
    }
}
