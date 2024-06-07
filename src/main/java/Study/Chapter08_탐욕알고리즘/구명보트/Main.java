package Study.Chapter08_탐욕알고리즘.구명보트;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {70, 50, 80, 50};
        solution(arr, 100);
    }

    static public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 오름차순으로 정렬
        Arrays.sort(people);

        // 보트에는 최대 2명까지만 탈 수 있다.
        // 따라서 가장 가벼운 사람과 가장 무거운 사람을 태운다.
        int l = 0, r = people.length - 1;
        while (l <= r) {
            // 가장 가벼운 사람과 무거운 사람 모두 탈 수 있는 경우
            if (people[l] + people[r] <= limit) {
                l++;
                r--;
                answer++;
            }
            // 그렇지 않다면 무거운 사람만 먼저 태운다.
            else {
                r--;
                answer++;
            }
        }
        
        return answer;
    }
}
