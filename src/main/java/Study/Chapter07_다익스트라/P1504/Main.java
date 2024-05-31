package Study.Chapter07_다익스트라.P1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] dist;
    static ArrayList<Node>[] graph;
    
    // 이동 거리로 올 수 있는 최대값 (200,000 * 1,000)
    // 간선은 최대 200,000개, 가중치 최대값은 1,000이기 때문
    static int INF = 200_000_000;

    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 생성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 그래프
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        // v1, v2 입력
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 두 가지 경로가 있다.
        // 1) start -> v1 -> v2 -> end
        // 2) start -> v2 -> v1 -> end
        // 따라서 다익스트라 알고리즘을 통해 5개의 값을 구하면 된다.
        // start -> v1, start -> v2
        // v1 <-> v2 (양방향 그래프이므로 한 번만 구하면 된다.)
        // v1 -> end, v2 -> end

        dijkstra(1);
        int startToV1 = dist[v1];

        dijkstra(1);
        int startToV2 = dist[v2];

        dijkstra(v1);
        int v1ToV2 = dist[v2];
        int v1ToEnd = dist[N];

        dijkstra(v2);
        int v2ToEnd = dist[N];

        int route1 = startToV1 + v1ToV2 + v2ToEnd;
        int route2 = startToV2 + v1ToV2 + v1ToEnd;

        if (route1 >= INF && route2 >= INF) {
            System.out.println(-1);
            return;
        }

        answer = Math.min(route1, route2);
        System.out.println(answer);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.idx] < cur.weight) {
                continue;
            }

            for (int i = 0; i < graph[cur.idx].size(); i++) {
                Node next = graph[cur.idx].get(i);

                int nextWeight = cur.weight + next.weight;
                if (dist[next.idx] > nextWeight) {
                    dist[next.idx] = nextWeight;
                    pq.offer(new Node(next.idx, nextWeight));
                }
            }
        }
    }
}
