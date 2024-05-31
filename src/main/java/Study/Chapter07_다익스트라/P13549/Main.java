package Study.Chapter07_다익스트라.P13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static int MAX_VALUE = 100000;

    static private class Node {
        // 연결되는 정점
        int idx;
        // 비용
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int min;
        dist = new int[MAX_VALUE + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        if (n > k) {
            min = n - k;
        } else {
            dijkstra(n);
            min = dist[k];
        }

        System.out.println(min);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.idx] < cur.weight) {
                continue;
            }

            int next = cur.idx - 1;
            int nextWeight = cur.weight + 1;
            if (next >= 0 && nextWeight < dist[next]) {
                dist[next] = nextWeight;
                pq.offer(new Node(next, nextWeight));
            }

            next = cur.idx + 1;
            nextWeight = cur.weight + 1;
            if (next <= MAX_VALUE && nextWeight < dist[next]) {
                dist[next] = nextWeight;
                pq.offer(new Node(next, nextWeight));
            }

            next = cur.idx * 2;
            nextWeight = cur.weight;
            if (next <= MAX_VALUE && nextWeight < dist[next]) {
                dist[next] = nextWeight;
                pq.offer(new Node(next, nextWeight));
            }
        }
    }
}
