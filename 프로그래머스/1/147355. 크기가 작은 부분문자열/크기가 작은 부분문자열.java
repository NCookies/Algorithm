class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int l = p.length();
        Long num = Long.parseLong(p);
        for (int i = 0; i < t.length() - l + 1; i++) {
            String s = t.substring(i, i + l);
            if (Long.parseLong(s) <= num) {
                answer++;
            }
        }
            
        return answer;
    }
}