import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] roots = IntStream.rangeClosed(0, Integer.parseInt(tokenizer.nextToken())).toArray();
        int M = Integer.parseInt(tokenizer.nextToken());
        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int type = Integer.parseInt(tokenizer.nextToken());
            int rootA = find(roots, Integer.parseInt(tokenizer.nextToken()));
            int rootB = find(roots, Integer.parseInt(tokenizer.nextToken()));
            if (type == 0) union(roots, rootA, rootB);
            else result.append(rootA == rootB ? "YES" : "NO").append("\n");
        }
    }

    private int find(int[] roots, int leaf) {
        return roots[leaf] = roots[leaf] == leaf ? leaf : find(roots, roots[leaf]);
    }

    private void union(int[] roots, int rootA, int rootB) {
        if (rootA <= rootB) roots[rootB] = rootA;
        else roots[rootA] = rootB;
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