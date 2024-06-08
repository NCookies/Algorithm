package Study.Chapter08_탐욕알고리즘.P1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 식을 가장 작은 수로 만들기 위해서는 최대한 많은 수를 더하고 앞에 "-" 연산자를 붙여서 음수로 만들어야 한다.
        // 이를 위해 "-"를 기준으로 식을 분리한다.
        String[] split = s.split("-");

        int answer = 0;

        for (int i = 0; i < split.length; i++) {
            String[] numbers = split[i].split("\\+");
            int sum = 0;
            for (String num : numbers) {
                sum += Integer.parseInt(num);
            }

            // 입력의 첫 번째 문자로는 숫자만 올 수 있기 때문에 첫 번째 덩어리는 항상 양수이다.
            if (i != 0) {
                answer -= sum;
            } else {
                answer += sum;
            }
        }

        System.out.println(answer);
    }
}
