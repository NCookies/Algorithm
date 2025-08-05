import java.util.Scanner;

public class Main {

    public static String solution(String str) {

        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(solution(sc.next()));
        }

    }

}
