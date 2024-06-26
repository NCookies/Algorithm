package Baekjoon_Level.Level03_반복문.P25304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum_price = Integer.parseInt(br.readLine());
        int types_num = Integer.parseInt(br.readLine());

        for (int i = 0; i < types_num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sum += (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
        }

        if (sum == sum_price) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
