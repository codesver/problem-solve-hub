import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int V = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());

        boolean[][] G = new boolean[V + 1][V + 1];
        boolean[] visited = new boolean[V + 1];

        while (E-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int VA = Integer.parseInt(tokenizer.nextToken());
            int VB = Integer.parseInt(tokenizer.nextToken());
            G[VA][VB] = G[VB][VA] = true;
        }

        int sub = 0;
        for (int v = 1; v <= V; v++)
            if (!visited[v]) {
                sub++;
                Queue<Integer> vs = new LinkedList<>(Collections.singleton(v));
                while (!vs.isEmpty()) {
                    Integer vertex = vs.poll();
                    for (int n = 1; n <= V; n++)
                        if (!visited[n] && G[vertex][n]) {
                            visited[n] = true;
                            vs.add(n);
                        }
                }
            }

        result.append(sub);
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