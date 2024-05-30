import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static private final StringBuilder sb = new StringBuilder();

    static private ArrayList<Node>[] graph;
    static int[][] result;

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

        result = new int[V + 1][V + 1];
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

        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i == j) {
                    sb.append("-").append(" ");
                } else {
                    sb.append(result[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start, int V) {
        int[] dist = new int[V + 1];

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

                    result[nextNode.idx][start] = curNode.idx;
                    queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
    }
}
