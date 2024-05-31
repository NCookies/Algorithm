import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    static int[][] map;
    static int[][] dist;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra();
        System.out.println(dist[n - 1][n - 1]);
    }

    private static void dijkstra() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 이동거리가 다음 위치와 차이가 없다면 연산할 필요가 없음
                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                && dist[cur.x][cur.y] < dist[nx][ny]) {
                    // 다음 위치가 흰 방이라면 변경 횟수는 증가하지 않음
                    if (map[nx][ny] == 1) {
                        dist[nx][ny] = dist[cur.x][cur.y];
                    } else {
                        // 다음 위치가 검은 방이라면 변경 횟수 증가
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    }
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
}
