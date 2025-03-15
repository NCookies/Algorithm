import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];
        
        for (int i = 0; i < length; i++) {
            answer[i] = getNumK(array, commands[i]);
        }
        
        return answer;
    }
    
    public int getNumK(int[] array, int[] command) {
        int[] tmp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
        Arrays.sort(tmp);
        return tmp[command[2] - 1];
    }
}