package Study.P10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(fiv(n));
    }

    static Long fiv(int x) {
        if (x == 1 || x == 2) {
            return 1L;
        } else {
            return fiv(x - 1) + fiv(x - 2);
        }
    }
}
