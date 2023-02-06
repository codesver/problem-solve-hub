import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int N, M, X, INF;

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        X = Integer.parseInt(tokenizer.nextToken());
        INF = 100 * (N - 1) + 1;

        int[][] natural = new int[N + 1][N + 1];
        int[][] reverse = new int[N + 1][N + 1];

        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int time = Integer.parseInt(tokenizer.nextToken());
            natural[from][to] = reverse[to][from] = time;
        }

        int[] nDistance = dijkstra(natural);
        int[] rDistance = dijkstra(reverse);

        result.append(IntStream.rangeClosed(1, N).map(v -> nDistance[v] + rDistance[v]).max().orElseThrow());
    }

    private static int[] dijkstra(int[][] graph) {
        Queue<Node> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        nodes.offer(new Node(X, 0));
        boolean[] visited = new boolean[N + 1];
        int[] distance = IntStream.generate(() -> INF).limit(N + 1).toArray();
        distance[X] = 0;

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            visited[node.number] = true;
            for (int n = 1; n <= N; n++) {
                if (!visited[n] && graph[node.number][n] != 0) {
                    distance[n] = Math.min(distance[n], distance[node.number] + graph[node.number][n]);
                    nodes.add(new Node(n, distance[n]));
                }
            }
        }
        return distance;
    }

    static class Node {

        int number, distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
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