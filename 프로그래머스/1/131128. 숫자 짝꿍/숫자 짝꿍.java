class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] jjak1 = new int[10];
        int[] jjak2 = new int[10];
                
        for (String s : X.split("")) {
            int num = Integer.parseInt(s);
            jjak1[num] = jjak1[num] + 1;
        }
        
        for (String s : Y.split("")) {
            int num = Integer.parseInt(s);
            jjak2[num] = jjak2[num] + 1;
        }
        
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < Math.min(jjak1[i], jjak2[i]); j++) {
                sb.append(i);
            }
        }
        
        if (sb.length() == 0) {
            return "-1";
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}
