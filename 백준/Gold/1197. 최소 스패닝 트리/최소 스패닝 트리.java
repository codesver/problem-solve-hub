import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private int[] parent;
    private final Queue<Edge> edges = new PriorityQueue<>();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int V = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());

        parent = IntStream.rangeClosed(0, V).toArray();
        while (E-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertexA = Integer.parseInt(tokenizer.nextToken());
            int vertexB = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            edges.offer(new Edge(vertexA, vertexB, weight));
        }

        int weight = 0, count = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (find(edge.vertexA) != find(edge.vertexB)) {
                union(edge.vertexA, edge.vertexB);
                weight += edge.weight;
                count++;
            }
            if (count == V - 1) break;
        }

        result.append(weight);
    }

    private int find(int vertex) {
        return parent[vertex] == vertex ? vertex : find(parent[vertex]);
    }

    private void union(int vertexA, int vertexB) {
        int parentA = find(vertexA);
        int parentB = find(vertexB);
        if (parentA < parentB) parent[parentB] = parentA;
        else parent[parentA] = parentB;
    }

    private void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}

class Edge implements Comparable<Edge> {

    int vertexA, vertexB, weight;

    public Edge(int vertexA, int vertexB, int weight) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}