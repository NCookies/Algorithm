import java.util.*;

public class Main {
    public static int solution(String str, char c) {
        int answer = 0;
        str = str.toLowerCase();
        c = Character.toLowerCase(c);
        for (char s : str.toCharArray()) {
            if (s == c) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);
        System.out.print(solution(str, c));
    }
}
