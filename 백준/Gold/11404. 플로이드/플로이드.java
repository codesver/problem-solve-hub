import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int N;
    private static int[][] infos;
    private static final int INF = 987654321;

    private static void solution() throws IOException {
        init();
        floydWarshall();
        show();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        infos = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) infos[i][j] = 0;
                else infos[i][j] = INF;
            }
        }
        StringTokenizer tokenizer;
        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());
            infos[from][to] = Math.min(infos[from][to], cost);
        }
    }

    private static void floydWarshall() {
        for (int mid = 1; mid <= N; mid++)
            for (int start = 1; start <= N; start++)
                for (int end = 1; end <= N; end++)
                    if (infos[start][end] > infos[start][mid] + infos[mid][end])
                        infos[start][end] = infos[start][mid] + infos[mid][end];
    }

    private static void show() {
        for (int from = 1; from <= N; from++) {
            for (int to = 1; to <= N; to++)
                result.append(infos[from][to] == INF ? 0 : infos[from][to]).append(" ");
            result.append("\n");
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