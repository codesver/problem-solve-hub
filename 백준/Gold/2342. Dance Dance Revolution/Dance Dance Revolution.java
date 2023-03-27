import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    final StringBuilder result = new StringBuilder();

    void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[][][] dp = new int[tokenizer.countTokens()][5][5];
        dp[0][0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int target = Integer.parseInt(tokenizer.nextToken());
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (dp[i - 1][r][c] > 0) {
                        if (target != r)
                            dp[i][r][target] = positiveMin(dp[i][r][target], dp[i - 1][r][c] + strength(c, target));
                        if (target != c)
                            dp[i][target][c] = positiveMin(dp[i][target][c], dp[i - 1][r][c] + strength(r, target));
                    }
                }
            }
        }
        result.append(Arrays.stream(dp[dp.length - 1]).flatMapToInt(Arrays::stream).filter(i -> i != 0).min().orElseThrow() - 1);
    }

    int positiveMin(int positiveAndZero, int positiveNum) {
        return positiveAndZero == 0 ? positiveNum : Math.min(positiveAndZero, positiveNum);
    }

    int strength(int original, int target) {
        return original == target ? 1 : original == 0 ? 2 : Math.abs(original - target) == 2 ? 4 : 3;
    }

    void finish() throws IOException {
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