package Study.Chatper09_동적프로그래밍.등굣길;

public class Main {
    public static void main(String[] args) {
        int[][] puddles = {{2, 2}};
        int[][] puddles2 = {{1, 3}};

        System.out.println(solution(4, 3, puddles));
        System.out.println(solution(4, 3, puddles2));
    }

    static public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        
        // 물에 잠긴 곳은 -1로 표시
        // 물에 잠긴 위치는 2차원 배열 표시가 아닌 (x, y) 좌표를 기준으로 주기 때문에 유의해야 함
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
