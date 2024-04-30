package Study.P4779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static String str;
    static char[] charArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder("_".repeat(n*n*n));
        str = "_".repeat(n*n*n);

        charArr = "_".repeat(n*n*n).toCharArray();

        cantor(str.length());

        System.out.println(sb);
    }

    static int cantor(int x) {
        if (x == 1) {
            return 1;
        } else {
            for (int i = x / 3; i < x / 3 * 2; i++) {
                charArr[i] = ' ';
            }
            return cantor(x / 3) + cantor(x * 2 /3);
        }
    }
}
