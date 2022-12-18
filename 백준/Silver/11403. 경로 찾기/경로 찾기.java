import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) graph[i][j] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int mid = 0; mid < N; mid++)
            for (int from = 0; from < N; from++)
                for (int to = 0; to < N; to++)
                    if (graph[from][mid] == 1 && graph[mid][to] == 1) graph[from][to] = 1;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                result.append(graph[i][j]).append(j == N - 1 ? "\n" : " ");
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