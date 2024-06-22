import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int MAX_X = 101;
    static int MAX_Y = 101;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[MAX_X][MAX_Y];
        int[][] distance = new int[MAX_X][MAX_Y];

        // 현재 위치 기준 상, 우, 하, 좌의 좌표
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 도형 내부는 true로 처리
        for (int[] rec : rectangle) {
            rec[0] *= 2;
            rec[1] *= 2;
            rec[2] *= 2;
            rec[3] *= 2;
            for (int i = rec[0]; i <= rec[2]; i++) {
                for (int j = rec[1]; j <= rec[3]; j++) {
                    if (i == rec[0] || i == rec[2]
                            || j == rec[1] || j == rec[3]) {
                        if (map[i][j] != 1) {
                            map[i][j] += 1;
                        }
                    } else {
                        map[i][j] += 2;
                    }
                }
            }
        }

        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(characterX, characterY));
        map[characterX][characterY] = 0;
        distance[characterX][characterY] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = point.x + dx[i];
                int nowY = point.y + dy[i];

                if (nowX >= 0 && nowX < MAX_X
                        && nowY >= 0 && nowY < MAX_Y
                        && map[nowX][nowY] == 1) {
                    map[nowX][nowY] = 0;

                    distance[nowX][nowY] = distance[point.x][point.y] + 1;
                    if (nowX == itemX && nowY == itemY) {
                        return distance[nowX][nowY] / 2;
                    }

                    queue.offer(new Point(nowX, nowY));
                }
            }
        }

        return -1;
    }
}