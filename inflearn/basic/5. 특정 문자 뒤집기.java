import java.util.Scanner;

public class Main {

    public static String solution(String str) {

        char[] charArr = str.toCharArray();
        int lt = 0;
        int rt = charArr.length - 1;

        while (lt < rt) {
            while (charArr[lt] < 'A' || charArr[lt] > 'z') lt++;
            while (charArr[rt] < 'A' || charArr[rt] > 'z') rt--;

            char tmp = charArr[lt];
            charArr[lt] = charArr[rt];
            charArr[rt] = tmp;

            lt++;
            rt--;
        }

        return String.valueOf(charArr);
    }

    // 특수문자 제외한 알파벳만 뒤집기
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(solution(str));

    }

}
