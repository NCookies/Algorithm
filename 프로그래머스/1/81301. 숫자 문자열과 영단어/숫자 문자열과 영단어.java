class Solution {
    public int solution(String s) {        
        String[] dic = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        
        for (int i = 0; i < dic.length; i++) {
            s = s.replace(dic[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}