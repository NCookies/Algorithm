package Study.Chatper09_동적프로그래밍.등굣길;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dp;
    static int min = Integer.MAX_VALUE;     // 최단거리
    static int cnt = 0;     // 최단경로 개수

    public static void main(String[] args) {
        int[][] puddles = {{2, 2}};
        System.out.println(solution(4, 3, puddles));
    }

    static public int solution(int m, int n, int[][] puddles) {
        dp = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }

        dfs(new Point(1, 1), 0);

        return cnt;
    }

    static void dfs(Point p, int depth) {
        // 좌표 벗어나면 리턴
        if (p.x > dp.length - 1|| p.y > dp[0].length - 1) {
            return;
        }

        // 가지 못하는 길임
        if (dp[p.x][p.y] == -1) {
            return;
        }

        dp[p.x][p.y] = ++depth;

        // 학교에 도달했을 때 최단거리와 최단경로 개수 갱신
        if (p.x == dp.length - 1 && p.y == dp[0].length - 1) {
            if (depth == min) {
                cnt++;
            } else if (depth < min) {
                min = depth;
                cnt = 1;
            }

            return;
        }

        dfs(new Point(p.x + 1, p.y), depth + 1);
        dfs(new Point(p.x , p.y + 1), depth + 1);
    }
}
