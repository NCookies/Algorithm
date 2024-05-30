import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static private StringBuilder sb = new StringBuilder();

    static private ArrayList<Node>[] graph;

    static private class Node {
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

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();   // 그래프 초기화
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 이 그래프는 양방향임
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        for (int i = 1; i < V + 1; i++) {
            dijkstra(i, V);
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start, int V) {
        int[] dist = new int[V + 1];
        int[] parents = new int[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (dist[curNode.idx] > curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph[curNode.idx].size(); i++) {
                Node nextNode = graph[curNode.idx].get(i);

                int nextWeight = curNode.weight + nextNode.weight;
                if (dist[nextNode.idx] > nextWeight) {
                    dist[nextNode.idx] = nextWeight;

                    // 최소 경로를 구한 노드의 부모 노드 기록
                    parents[nextNode.idx] = curNode.idx;
                    queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

        traceRoute(parents, start);
    }

    // 부모 배열 사용하여 경로 역추적
    private static void traceRoute(int[] parents, int start) {
        for (int i = 1; i < parents.length; i++) {
            if (i == start) {
                sb.append("- ");
                continue;
            }
            int answer = 0;
            // 부모 노드가 start일 때까지 answer 갱신
            for (int j = i; j != start; j = parents[j]) {
                answer = j;
            }
            sb.append(answer).append(" ");
        }
        sb.append("\n");
    }
}
