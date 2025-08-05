import java.util.Scanner;

public class Main {

    public static String solution(String str) {
        String[] splits = str.split(" ");

        int maxLength = -1;
        String answer = "";

        for (String s : splits) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                answer = s;
            }
        }

        return answer;
    }

    /**
     * 강의에서 제시한 indexOf(), substring() 메서드를 사용해서 풀이 방식
     * 공백이 위치한 인덱스를 찾고 조건에 맞으면 substring()으로 문자열을 추출한다.
     * 근데 매번 루프마다 문자열 연산(substring())을 해야해서 효율적인지는 모르겠다.
     */
    public static String solution2(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        int pos;

        while ((pos=str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            if (tmp.length() > m) {
                m = tmp.length();
                answer = tmp;
            }

            str = str.substring(pos + 1);
        }

        if (str.length() > m) {
            answer = str;
        }

        return answer;
    }

    /**
     * ChatGPT에서 제시한 가장 효율적인 방법
     * split이나 반복적인 substring 없이 최적의 성능을 얻을 수 있다고 한다.
     * substring()은 결과 단어 한 번만 생성하므로 메모리 사용을 최소화하기 때문이다.
     * 
     * 근데 단어 개수가 굉장히 많을 때에나 유효하고, 가독성 측면에서는 내가 작성한 코드가 제일 나은 것 같다.
     */
    public static String solution3(String str) {
        int start = 0, maxLen = 0, maxStart = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == ' ') {
                int len = i - start;
                if (len > maxLen) {
                    maxLen = len;
                    maxStart = start;
                }
                start = i + 1;
            }
        }
        return str.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();

        System.out.println(solution(input));
    }

}
