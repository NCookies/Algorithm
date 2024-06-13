package Baekjoon_Level.Level23_동적계획법1.P1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(tile(n));
    }

    static public int tile(int x) {
        if (x == 1) {
            return 1;
        }
        if (x == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int sum = 0;

        for (int i = 2; i < x; i++) {
            sum = (a + b) % 15746;
            a = b;
            b = sum;
        }

        return sum;
    }
}
