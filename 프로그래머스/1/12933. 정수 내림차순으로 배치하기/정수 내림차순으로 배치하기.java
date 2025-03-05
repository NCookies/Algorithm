import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String[] digits = Long.toString(n).split("");
        Arrays.sort(digits, Collections.reverseOrder());
        
        String sortedNum = String.join("", digits);
        
        return Long.parseLong(sortedNum);
    }
}