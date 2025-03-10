class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int columnLength = arr1.length;
        int rowLength = arr1[0].length;
        int[][] answer = new int[columnLength][rowLength];
        
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}