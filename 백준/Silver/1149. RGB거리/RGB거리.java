import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[][] cost = new int[N + 1][3];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int c = 0; c < 3; c++)
            cost[1][c] = Integer.parseInt(tokenizer.nextToken());

        for (int h = 2; h <= N; h++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < 3; c++)
                cost[h][c] = Math.min(cost[h - 1][(c + 1) % 3], cost[h - 1][(c + 2) % 3])
                        + Integer.parseInt(tokenizer.nextToken());
        }

        result.append(Math.min(Math.min(cost[N][0], cost[N][1]), cost[N][2]));
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