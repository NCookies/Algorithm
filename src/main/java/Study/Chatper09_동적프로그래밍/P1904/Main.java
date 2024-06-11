package Study.Chatper09_동적프로그래밍.P1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int zeroCnt = 2;

        while (zeroCnt <= n) {
            answer += (n - (zeroCnt - 1)) % 15746;
            zeroCnt += 2;
        }

        // n이 짝수이면 전부 1일 경우만 추가
        // n이 홀수면 전부 0이거나 전부 1인 경우 추가
        if (n % 2 == 0) {
            System.out.println(answer + 1);
        } else {
            System.out.println(answer + 2);
        }
    }
}
