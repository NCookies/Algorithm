package Baekjoon_Level.Level23_동적계획법1.P24416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        fib(n);
        sb.append(++cnt).append(" ");
        cnt = 0;

        fib2(n);
        sb.append(cnt);

        System.out.println(sb);
    }
    
    // 재귀 함수
    static public int fib(int x) {
        if (x == 1 || x == 2) {
            return 1;
        } else {
            cnt++;
            return fib(x - 1) + fib(x - 2);
        }
    }
    
    // 동적 프로그래밍
    static public int fib2(int x) {
        int[] arr = new int[x];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < x; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            cnt++;
        }

        return arr[x - 1];
    }
}
