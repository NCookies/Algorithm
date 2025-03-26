class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int ci1 = 0;    // cards1 index
        int ci2 = 0;    // cards2 index
        
        for (String find : goal) {
            if (ci1 < cards1.length && find.equals(cards1[ci1])) {
                ci1++;
            } else if (ci2 < cards2.length && find.equals(cards2[ci2])) {
                ci2++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}
