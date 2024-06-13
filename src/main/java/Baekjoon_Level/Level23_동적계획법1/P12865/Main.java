package Baekjoon_Level.Level23_동적계획법1.P12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
public class Main {
    static class Stuff {
        int weight;
        int value;

        public Stuff(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 물건 종류 개수
        int n = Integer.parseInt(st.nextToken());

        // 최대 무게
        int k = Integer.parseInt(st.nextToken());

        // 물건 정보 입력
        Stuff[] stuff = new Stuff[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stuff[i] = new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[][] backpack = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                // 두 개의 항목 중 더 큰 값을 대입한다.
                // 1. backpack[i-1][j]
                // 2. 현재 물건의 가치 + 남은 공간의 가치(backpack[i-1][j-현재 물건의 무게])
                if (stuff[i - 1].weight <= j) {
                    backpack[i][j] = Math.max(backpack[i - 1][j],
                            stuff[i - 1].value + backpack[i - 1][j - stuff[i - 1].weight]);
                } else {
                    backpack[i][j] = backpack[i - 1][j];
                }
            }
        }

        System.out.println(backpack[n][k]);
    }
}
