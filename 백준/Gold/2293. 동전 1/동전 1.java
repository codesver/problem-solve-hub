import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int T = Integer.parseInt(tokenizer.nextToken());
        int[] dp = new int[T + 1];
        dp[0] = 1;
        while (N-- > 0) {
            int coin = Integer.parseInt(reader.readLine());
            for (int c = coin; c <= T; c++) dp[c] += dp[c - coin];
        }
        result.append(dp[T]);
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