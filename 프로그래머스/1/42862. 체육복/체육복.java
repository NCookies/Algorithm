class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1. 배열 초기화 ex) 1, -1, 1, -1, 1 / 0, -1, 1, -1, 0
        // 2. 체육복 분배 ex) 0, 0, 0, 0, 1 / 0, 0, 0, -1, 0
        // 3. 체육복 1개 이상인 사람 카운트
        int answer = 0;
        int[] arr = new int[n + 1];
        
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]] = -1;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]] = arr[reserve[i]] + 1;
        }
        
        for (int j = 1; j <= n; j++) {
            if (arr[j] == -1) {
                if (j != 1 && arr[j - 1] == 1) {
                    arr[j - 1] = 0;
                    arr[j] = 0;
                } else if (j != n && arr[j + 1] == 1) {
                    arr[j + 1] = 0;
                    arr[j] = 0;
                }
            }
        }
        
        for (int k = 1; k <= n; k++) {
            if (arr[k] >= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}