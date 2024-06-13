package Study.Chatper09_동적프로그래밍.P2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] weight = new int[31];

    // 추의 개수는 최대 30개까지, 무게는 최대 15000g이 될 수 있다.
    static boolean[][] dp = new boolean[31][15001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 추 입력
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);

        int balls = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < balls; i++) {
            int ball = Integer.parseInt(st.nextToken());
            if (ball > 15000) {
                sb.append("N").append(" ");
            } else {
                String result = dp[n][ball] ? "Y" : "N";
                sb.append(result).append(" ");
            }
        }


        System.out.println(sb);
    }

    static void solve(int i, int w) {
        // 재귀 종료 조건
        // 모든 추의 개수를 조합해 봤거나, 이미 추들로 완성했던 무게는 스킵
        if (i > n || dp[i][w]) {
            return;
        }

        dp[i][w] = true;
        solve(i + 1, w + weight[i]);
        solve(i + 1,  Math.abs(w - weight[i]));
        solve(i + 1, w);
    }
}
