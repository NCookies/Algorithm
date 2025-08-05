class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int same = 0;   // 같은 숫자 개수
        int zero = 0;   // 0 개수
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
            
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    same++;
                }
            }
        }
        
        answer[0] = getRank(same + zero);
        answer[1] = getRank(same);
        
        return answer;
    }
    
    public int getRank(int n) {
        return switch (n) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}