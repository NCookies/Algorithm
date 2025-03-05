import java.util.*;

public class Solution {
    public int solution(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        
        int sum = 0;
        for (char c : digits) {
            sum += c - 48;
        }

        return sum;
    }
}