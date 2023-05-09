import java.io.*;
import java.util.Arrays;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int numberOfCoins = Integer.parseInt(reader.readLine());
            int[] coins = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int targetMoney = Integer.parseInt(reader.readLine());

            int[] dp = new int[targetMoney + 1];
            dp[0] = 1;
            for (int coin : coins)
                for (int c = coin; c <= targetMoney; c++) dp[c] += dp[c - coin];

            result.append(dp[targetMoney]).append('\n');
        }
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