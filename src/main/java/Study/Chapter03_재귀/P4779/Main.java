package Study.Chapter03_재귀.P4779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] charArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        
        // 입력 끝날 때까지 루프
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            
            // 3^n 만큼 "-" 반복
            charArr = "-".repeat((int) Math.pow(3, n)).toCharArray();

            // 완전 이진 트리의 전위 탐색 과정과 유사함
            cantor(charArr.length, 0);
            System.out.println(charArr);
        }
    }

    static void cantor(int length, int startIndex) {
        // 선의 길이가 1이 되면 재귀 종료
        if (length == 1) {
            return;
        }

        //
        int nextLength = length / 3;

        // 3등분한 가운데 문자열을 공백으로 대체
        for (int i = 0; i < nextLength; i++) {
            charArr[i + startIndex + nextLength] = ' ';
        }

        // 각각 3등분 후의 왼쪽과 오른쪽 문자열에 재귀 함수 호출
        cantor(nextLength, startIndex);
        cantor(nextLength, startIndex + 2 * nextLength);
    }
}
