import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int[] dp = new int[]{0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 4; i < 11; i++) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) result.append(dp[Integer.parseInt(reader.readLine())]).append("\n");
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