class Solution {
    public int solution(int[][] sizes) {
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