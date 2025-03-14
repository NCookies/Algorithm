import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        Arrays.sort(strings, Comparator.comparing((String s) -> s.charAt(n))
                                       .thenComparing(Comparator.naturalOrder()));
        
        return strings;
    }
}
