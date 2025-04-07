class Solution {
    
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    answer += isPrime(nums[i] + nums[j] + nums[k]) ? 1 : 0;
                }
            }
        }

        return answer;
    }
    
    private boolean isPrime(int num) {
        
        for (int n = 2; n <= Math.sqrt(num); n++) {
            if (num % n == 0) {
                return false;
            }
        }
        
        return true;
    }
    
}