import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[][] homes = new int[N][3];
        
        StringTokenizer tokenizer;
        for (int h = 0; h < N; h++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < 3; c++) homes[h][c] = Integer.parseInt(tokenizer.nextToken());
        }

        final int INF = 1_000_001;
        int minCost = Integer.MAX_VALUE;

        for (int s = 0; s < 3; s++) {
            int[][] dp = Arrays.stream(homes).map(int[]::clone).toArray(int[][]::new);
            dp[0][(s + 1) % 3] = dp[0][(s + 2) % 3] = INF;
            for (int h = 1; h < N; h++)
                for (int c = 0; c < 3; c++)
                    dp[h][c] += Math.min(dp[h - 1][(c + 1) % 3], dp[h - 1][(c + 2) % 3]);
            minCost = Math.min(minCost, Math.min(dp[N - 1][(s + 1) % 3], dp[N - 1][(s + 2) % 3]));
        }

        result.append(minCost);
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