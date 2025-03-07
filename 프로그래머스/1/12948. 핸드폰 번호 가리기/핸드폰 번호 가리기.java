class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int length = phone_number.length();
        
        return sb.append("*".repeat(length - 4)).append(phone_number.substring(length - 4)).toString();
    }
}