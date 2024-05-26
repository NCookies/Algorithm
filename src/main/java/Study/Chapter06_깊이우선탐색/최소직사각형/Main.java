package Study.Chapter06_깊이우선탐색.최소직사각형;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] test = {{60, 50},{30, 70},{60, 30},{80, 40}};
        System.out.println(solution(test));
    }

    static public int solution(int[][] sizes) {
        int maxHeight = Integer.MIN_VALUE;
        int maxWidth = Integer.MIN_VALUE;

        for (int[] size : sizes) {
            int h = Math.max(size[0], size[1]);
            int w = Math.min(size[0], size[1]);

            if (h > maxHeight) {
                maxHeight = h;
            }
            if (w > maxWidth) {
                maxWidth = w;
            }
        }

        return maxHeight * maxWidth;
    }
}
