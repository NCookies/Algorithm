import java.util.Scanner;

public class Main {

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        int diff = 'a' - 'A';

        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') c += diff;
            else if (c >= 'a' && c <= 'z') c -= diff;

            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();

        System.out.println(solution(input));
    }

}
