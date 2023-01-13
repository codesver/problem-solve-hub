import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static final Map<Integer, Map<Integer, Integer>> tree = new HashMap<>();
    private static final Map<Integer, Boolean> visited = new HashMap<>();
    private static int maxWeight = 0, maxLeaf = 0;

    private static void solution() throws IOException {
        int NODE = Integer.parseInt(reader.readLine());
        if (NODE == 1) result.append(0);
        else {
            IntStream.rangeClosed(1, NODE).forEach(node -> {
                tree.put(node, new HashMap<>());
                visited.put(node, false);
            });
            StringTokenizer tokenizer;
            while (NODE-- > 1) {
                tokenizer = new StringTokenizer(reader.readLine());
                int P = Integer.parseInt(tokenizer.nextToken());
                int C = Integer.parseInt(tokenizer.nextToken());
                int W = Integer.parseInt(tokenizer.nextToken());

                tree.get(P).put(C, W);
                tree.get(C).put(P, W);
            }

            dfs(1, 0);
            dfs(maxLeaf, 0);
            result.append(maxWeight);
        }
    }

    private static void dfs(int node, int weight) {
        visited.put(node, true);
        boolean isLeaf = true;
        for (Map.Entry<Integer, Integer> edge : tree.get(node).entrySet()) {
            if (!visited.get(edge.getKey())) {
                isLeaf = false;
                dfs(edge.getKey(), weight + edge.getValue());
            }
        }
        if (isLeaf && maxWeight < weight) {
            maxWeight = weight;
            maxLeaf = node;
        }
        visited.put(node, false);
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