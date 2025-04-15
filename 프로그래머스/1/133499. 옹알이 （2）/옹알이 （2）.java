class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            
            // 불가능한 발음들
            if (babbling[i].contains("ayaaya") 
                || babbling[i].contains("yeye") 
                || babbling[i].contains("woowoo") 
                || babbling[i].contains("mama")) {
                continue;
            }
            
            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");     // yayae 같은 케이스 거르기 위해 " "를 ""로 대체
            
            if (babbling[i].length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
