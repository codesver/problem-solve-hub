import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int V, E;
    private static int[][] graph;
    private static boolean[] visited;
    private static int[] distance;
    private static final int INF = 200_000_000;

    private static void solution() throws IOException {
        // Initializing
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        V = Integer.parseInt(tokenizer.nextToken());
        E = Integer.parseInt(tokenizer.nextToken());
        graph = new int[V + 1][V + 1];
        visited = new boolean[V + 1];
        distance = new int[V + 1];

        // Assigning
        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            graph[u][v] = graph[v][u] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int V1 = Integer.parseInt(tokenizer.nextToken());
        int V2 = Integer.parseInt(tokenizer.nextToken());

        // Solving
        int min = Math.min(dijkstra(1, V1) + dijkstra(V1, V2) + dijkstra(V2, V),
                dijkstra(1, V2) + dijkstra(V2, V1) + dijkstra(V1, V));

        result.append(min >= INF ? -1 : min);
    }

    private static int dijkstra(int from, int to) {
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);

        Queue<Node> nodes = new PriorityQueue<>(Collections.singleton(new Node(from, 0)));
        distance[from] = 0;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            visited[node.num] = true;
            if (node.num == to) return distance[node.num];
            nodes.clear();
            for (int v = 1; v <= V; v++) {
                if (!visited[v] && graph[node.num][v] != 0) {
                    distance[v] = Math.min(distance[v], distance[node.num] + graph[node.num][v]);
                    nodes.add(new Node(v, distance[v]));
                }
            }
        }

        return distance[to];
    }

    static class Node implements Comparable<Node> {

        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    private static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}