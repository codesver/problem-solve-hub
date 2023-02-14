import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    public static int N;
    public static int[] D;
    public static final List<Edge> edges = new ArrayList<>();
    public static final int INF = 5_000_000;

    public static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            init();
            result.append(travel() ? "YES" : "NO").append("\n");
        }
    }

    public static void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int W = Integer.parseInt(tokenizer.nextToken());
        edges.clear();

        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int S = Integer.parseInt(tokenizer.nextToken());
            int E = Integer.parseInt(tokenizer.nextToken());
            int T = Integer.parseInt(tokenizer.nextToken());
            edges.add(new Edge(S, E, T));
            edges.add(new Edge(E, S, T));
        }

        while (W-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int S = Integer.parseInt(tokenizer.nextToken());
            int E = Integer.parseInt(tokenizer.nextToken());
            int T = Integer.parseInt(tokenizer.nextToken());
            edges.add(new Edge(S, E, -T));
        }
    }

    public static boolean travel() {
        Loop:
        for (int node = 1; node <= N; node++) {
            D = new int[N + 1];
            Arrays.fill(D, INF);
            D[node] = 0;
            for (int i = 0; i < N - 1; i++) if (!searchEdge()) continue Loop;
            if (searchEdge()) return true;
        }
        return false;
    }

    public static boolean searchEdge() {
        boolean update = false;
        for (Edge e : edges)
            if (D[e.from] != INF && D[e.to] > D[e.from] + e.time) {
                D[e.to] = D[e.from] + e.time;
                update = true;
            }
        return update;
    }

    static class Edge {

        int from, to, time;

        public Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    public static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}