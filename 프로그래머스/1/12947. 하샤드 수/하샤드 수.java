class Solution {
    public boolean solution(int x) {int sum = 0;
        char[] digits = Integer.toString(x).toCharArray();
        
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i] - 48;
        }
        
        return (x % sum == 0);
    }
}