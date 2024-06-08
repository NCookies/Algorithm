package Study.Chapter08_탐욕알고리즘.조이스틱;

public class Main {
    public static void main(String[] args) {
        solution("JEROEN");
    }

    static public int solution(String name) {
        int answer = 0;

        int n = name.length();
        int upDown = 0;
        int leftRight = n - 1;

        for (int i = 0; i < n; i++) {
            if (name.charAt(i) <= 'N') {
                upDown += name.charAt(i) - 65;
            } else {
                upDown += 91 - name.charAt(i);
            }

            // 연속된 A의 다음 문자를 찾을 때까지 탐색
            int nextMove = i + 1;
            while (nextMove < n && name.charAt(nextMove) == 'A') {
                nextMove++;
            }

            leftRight = Math.min(leftRight,
                        Math.min(i + i + (n - nextMove), (n - nextMove) + (n - nextMove) + i));
        }

        answer = upDown + leftRight;
        return answer;
    }
}
