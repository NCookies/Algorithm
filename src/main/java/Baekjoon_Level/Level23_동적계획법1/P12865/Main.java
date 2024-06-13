package Baekjoon_Level.Level23_동적계획법1.P12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 물건 종류 개수
        int n = Integer.parseInt(st.nextToken());

        // 최대 무게
        int k = Integer.parseInt(st.nextToken());

        int[][] backpack = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; i++) {
            // 물건 정보 입력
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            for (int j = 1; j < k + 1; j++) {
                // 두 개의 항목 중 더 큰 값을 대입한다.
                // 1. backpack[i-1][j]
                // 2. 현재 물건의 가치 + 남은 공간의 가치(backpack[i-1][j-현재 물건의 무게])
                if (weight <= j) {
                    backpack[i][j] = Math.max(backpack[i - 1][j],
                            value + backpack[i - 1][j - weight]);
                } else {
                    backpack[i][j] = backpack[i - 1][j];
                }
            }
        }

        System.out.println(backpack[n][k]);
    }
}
