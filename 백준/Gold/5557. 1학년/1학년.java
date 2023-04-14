import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();


    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        long[][] dp = new long[N - 1][21];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        dp[0][Integer.parseInt(tokenizer.nextToken())]++;
        for (int step = 1; step < dp.length; step++) {
            int number = Integer.parseInt(tokenizer.nextToken());
            for (int num = 0; num <= 20; num++) {
                if (dp[step - 1][num] != 0) {
                    if (num - number >= 0) dp[step][num - number] += dp[step - 1][num];
                    if (num + number <= 20) dp[step][num + number] += dp[step - 1][num];
                }
            }
        }
        result.append(dp[dp.length - 1][Integer.parseInt(tokenizer.nextToken())]);
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