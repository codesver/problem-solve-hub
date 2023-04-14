import java.io.*;
import java.util.Arrays;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();


    public void solve() throws IOException {
        String code = 9 + reader.readLine().replaceAll("[12]0", "-");
        int[] dp = new int[code.length()];
        dp[0] = 1;
        for (int i = 1; i < code.length(); i++) {
            char pre = code.charAt(i - 1);
            char cur = code.charAt(i);

            if (cur == '-') {
                dp[i] = dp[i - 1];
                continue;
            }
            if (Character.getNumericValue(cur) == 0) break;
            if (pre == '-') {
                dp[i] = dp[i - 1];
                continue;
            }
            int connect = Character.getNumericValue(pre) * 10 + Character.getNumericValue(cur);
            if (10 < connect && connect <= 26) dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000;
            else dp[i] = dp[i - 1];
        }
        result.append(dp[dp.length - 1]);
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