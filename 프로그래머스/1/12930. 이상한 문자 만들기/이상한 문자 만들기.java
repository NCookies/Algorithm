class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        // 대문자로 바꾸기
        boolean flag = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 32) {
                flag = true;
                sb.append(" ");
                continue;
            }
            
            if (flag) {
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
                flag = false;
            } else {
                sb.append(String.valueOf(s.charAt(i)).toLowerCase());
                flag = true;
            }
        }
        
        
        return sb.toString();
    }
}