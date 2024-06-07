package Study.Chapter08_탐욕알고리즘.구명보트;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {70, 50, 80, 50};
        solution(arr, 100);
    }

    static public int solution(int[] people, int limit) {
        int answer = 1;
        
        // 오름차순으로 정렬
        Arrays.sort(people);


        int boatPeople = 0;
        int weight = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (weight + people[i] <= limit) {
                weight += people[i];
                boatPeople++;
            } else {
                weight = people[i];
                answer++;
                boatPeople = 0;
            }

            // 보트는 최대 2명까지만 탑승 가능
            if (boatPeople == 2) {
                weight = 0;
                answer++;
                boatPeople = 0;
            }
        }
        
        return answer;
    }
}
