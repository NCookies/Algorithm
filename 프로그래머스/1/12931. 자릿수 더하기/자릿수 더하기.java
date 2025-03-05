import java.util.*;

public class Solution {
    public int solution(int n) {
        String[] digits = String.valueOf(n).split("");
        
        int sum = 0;
        for (String s : digits) {
            sum += Integer.valueOf(s);
        }

        return sum;
    }
}