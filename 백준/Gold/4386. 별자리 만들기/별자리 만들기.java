import java.io.*;
import java.util.*;

class Node {

    int n;
    double x, y;

    public Node(int n, double x, double y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }

    public double distance(Node node) {
        return Math.sqrt(Math.pow(x - node.x, 2) + Math.pow(y - node.y, 2));
    }
}

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private final List<Node> nodes = new ArrayList<>(Collections.singleton(null));
    private final Map<Integer, Map<Integer, Double>> graph = new HashMap<>();

    public void solve() throws IOException {
        StringTokenizer tokenizer;
        int N = Integer.parseInt(reader.readLine());
        for (int n = 1; n <= N; n++) {
            tokenizer = new StringTokenizer(reader.readLine());
            double x = Double.parseDouble(tokenizer.nextToken());
            double y = Double.parseDouble(tokenizer.nextToken());
            Node node = new Node(n, x, y);
            nodes.add(node);
            graph.put(n, new HashMap<>());
        }
        for (int i = 1; i <= N; i++) {
            Node nodeI = nodes.get(i);
            for (int j = i + 1; j <= N; j++) {
                Node nodeJ = nodes.get(j);
                double distance = nodeI.distance(nodeJ);
                graph.get(nodeI.n).put(nodeJ.n, distance);
                graph.get(nodeJ.n).put(nodeI.n, distance);
            }
        }

        double weight = 0;
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        Queue<Map.Entry<Integer, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        queue.addAll(graph.get(1).entrySet());
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Double> edge = queue.poll();
            if (visited[edge.getKey()]) continue;
            visited[edge.getKey()] = true;
            weight += edge.getValue();
            queue.addAll(graph.get(edge.getKey()).entrySet());
        }
        result.append(weight);
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