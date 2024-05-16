package Study.Chapter5_해시.P1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> stringBooleanHashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            stringBooleanHashMap.put(br.readLine(), true);
        }

        List<String> arr = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            String s = br.readLine();
            if (stringBooleanHashMap.containsKey(s)) {
                arr.add(s);
            }
        }

        Collections.sort(arr);

        sb.append(arr.size()).append("\n");
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
