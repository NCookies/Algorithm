package Study.Chapter08_탐욕알고리즘.P2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        // 가장 적은 수의 봉지를 들고 가려면 5키로 봉지를 가능한 많이 챙겨야 한다.
        // n이 5로 나누어 떨어질 때까지 3씩 뺀다.
        while (n >= 0) {
            if (n % 5 == 0) {
                System.out.println(n / 5 + answer);
                return;
            }

            n -= 3;
            answer++;
        }

        // 루프가 종료될 때까지 답을 구하지 못하면 -1 출력
        System.out.println(-1);
    }
}
