package Study.Chapter5_해시.P26008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int h = Integer.parseInt(br.readLine());

        /*
         * 가능한 배열의 조합의 수는 m^n개다. 각 배열의 요소마다 m개의 선택지가 있기 때문이다.
         * 미자막에 m으로 mod 연산을 하므로 해시값 h는 0부터 m-1까지의 숫자가 같은 확률로 나온다.
         * 따라서 특정 해시값이 나올 경우는 m^n / n, 즉 m^(n-1)개이다.
         * 이를 마지막에 1000000007으로 나머지 연산해주면 되는데,
         * 중간에 값이 매우 커지므로 매 연산마다 나머지 연산을 수행한다.
         */
        long answer = 1;
        for (int i = 0; i < n - 1; i++) {
            answer = (answer * m) % 1000000007;
        }

        System.out.println(answer);
    }
}
