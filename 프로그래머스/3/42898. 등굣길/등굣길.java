class Solution {
    static public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        // 시작점(dp[1][1])을 1로 초기화하기 위해 설정
        dp[0][1] = 1;
        int sum = 0;

        // 현재 위치로 올 수 있는 경로의 개수는 dp 배열의 위와 왼쪽의 값을 더한 값이다.
        // 만약 -1일 경우에는 합 연산에서 제외한다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }

                sum = 0;
                if (dp[i - 1][j] != -1) {
                    sum += dp[i - 1][j];
                }
                if (dp[i][j - 1] != -1) {
                    sum += dp[i][j - 1];
                }

                dp[i][j] = sum % 1000000007;
            }
        }

        return dp[n][m];
    }
}