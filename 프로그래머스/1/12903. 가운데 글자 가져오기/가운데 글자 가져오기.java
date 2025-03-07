class Solution {
    public String solution(String s) {
        String answer = "";
        int mid = s.length() / 2;
        StringBuilder sb = new StringBuilder();
        
        if (s.length() <= 2) {
            return s;
        }
        
         // 길이가 홀수이면 가운데 한 글자, 짝수이면 가운데 두 글자 반환
        return (s.length() % 2 == 0) ? s.substring(mid - 1, mid + 1) : s.substring(mid, mid + 1);
    }
}