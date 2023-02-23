import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public int V;
    public final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    public void solve() throws IOException {
        init();
        Vertex end = search(new Vertex(1, 0));
        end = search(new Vertex(end.node, 0));
        result.append(end.distance);
    }

    private void init() throws IOException {
        V = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        IntStream.rangeClosed(1, V).forEach(v -> map.put(v, new HashMap<>()));
        for (int v = 0; v < V; v++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to, distance;
            while ((to = Integer.parseInt(tokenizer.nextToken())) != -1) {
                distance = Integer.parseInt(tokenizer.nextToken());
                map.get(from).put(to, distance);
            }
        }
    }

    private Vertex search(Vertex start) {
        Vertex end = new Vertex(0, Integer.MIN_VALUE);
        boolean[] visited = new boolean[V + 1];
        visited[start.node] = true;

        Stack<Vertex> vertices = Stream.of(start).collect(Collectors.toCollection(Stack::new));
        while (!vertices.isEmpty()) {
            Vertex vertex = vertices.pop();
            end.compare(vertex);
            for (Map.Entry<Integer, Integer> entry : map.get(vertex.node).entrySet()) {
                if (!visited[entry.getKey()]) {
                    visited[entry.getKey()] = true;
                    vertices.push(new Vertex(entry.getKey(), vertex.distance + entry.getValue()));
                }
            }
        }
        return end;
    }

    public void finish() throws IOException {
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

class Vertex {

    int node, distance;

    public Vertex(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public void compare(Vertex vertex) {
        if (vertex.distance > distance) {
            node = vertex.node;
            distance = vertex.distance;
        }
    }
}