package Study.P23883;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 각 숫자가 몇 번째 인덱스에 있는지 저장하고 있는 배열
        TreeMap<Integer, Integer> idxMap = new TreeMap<>();

        // 수열 A를 저장하고 있는 배열
        int[] numArr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());;
            idxMap.put(num, i);
            numArr[i] = num;
        }
        
        int times = 0;      // 교환 횟수

        // selection sort
        for (int i = n; i > 0; i--) {
            // 수열 A 중 가장 큰 값을 key로, 인덱스를 value로 가지는 Map 변수 반환
            Map.Entry<Integer, Integer> max = idxMap.pollLastEntry();

            // i 위치의 값이 max가 아닌 경우
            if (numArr[i] != max.getKey()) {
                if (++times >= k) {
                    sb.append(numArr[i]).append(" ").append(i);
                    System.out.println(sb);
                    return;
                }

                int tmp = idxMap.get(numArr[i]);    // 5
                idxMap.put(numArr[i], max.getValue());  // 4
                idxMap.put(max.getKey(), tmp);      // 5

                tmp = numArr[max.getValue()];
                numArr[max.getValue()] = numArr[i];
                numArr[i] = tmp;

//                idxMap.put(numArr[i], max.getValue());
//                numArr[max.getValue()] = numArr[i];

//                int tmp = idxArr[numArr[i]];
//                idxArr[numArr[i]] = idxArr[i];
//                idxArr[i] = tmp;
//
//                tmp = numArr[maxIndex];
//                numArr[maxIndex] = numArr[i];
//                numArr[i] = tmp;
            }
        }

        System.out.println(-1);
    }
}
