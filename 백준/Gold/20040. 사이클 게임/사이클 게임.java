import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private int[] roots;

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        roots = IntStream.range(0, N).toArray();
        int m = 1;
        for (; m <= M; m++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int nodeA = Integer.parseInt(tokenizer.nextToken());
            int nodeB = Integer.parseInt(tokenizer.nextToken());
            int rootA = find(nodeA);
            int rootB = find(nodeB);
            if (rootA == rootB) break;
            union(rootA, rootB);
        }
        result.append(m <= M ? m : 0);
    }

    private int find(int node) {
        if (node == roots[node]) return node;
        else return find(roots[node]);
    }

    private void union(int rootA, int rootB) {
        if (rootA < rootB) roots[rootB] = rootA;
        else roots[rootA] = rootB;
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