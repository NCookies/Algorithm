package Baekjoon_Level.Level23_동적계획법1.P9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        dp = new int[a.length() + 1][b.length() + 1];

        // 최장 공통 부분 수열 길이 탐색
        lcs(a, b);

        System.out.println(dp[a.length()][b.length()]);
    }

    static void lcs(String a, String b) {
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j -1]);
                }
            }
        }
    }
}
