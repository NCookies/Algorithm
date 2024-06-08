import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] split = s.split("-");

        int answer = 0;

        for (int i = 0; i < split.length; i++) {
            String[] numbers = split[i].split("\\+");
            int sum = 0;
            for (String num : numbers) {
                sum += Integer.parseInt(num);
            }

            if (i != 0) {
                answer -= sum;
            } else {
                answer += sum;
            }
        }

        System.out.println(answer);
    }
}
