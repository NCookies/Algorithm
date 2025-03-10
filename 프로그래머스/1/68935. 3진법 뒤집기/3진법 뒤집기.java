class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 3);
            n = n / 3;
        }
        
        int p = 1;
        for (String s : sb.reverse().toString().split("")) {
            answer += Integer.parseInt(s) * p;
            p *= 3;
        }
        
        return answer;
    }
}