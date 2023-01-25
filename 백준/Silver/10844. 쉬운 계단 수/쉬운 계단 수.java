import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        final int MOD = 1_000_000_000;
        final int LEN = Integer.parseInt(reader.readLine());
        final int[][] counter = new int[LEN][12];
        Arrays.fill(counter[0], 1);
        counter[0][0] = counter[0][1] = counter[0][11] = 0;
        for (int l = 1; l < LEN; l++) {
            for (int n = 1; n <= 10; n++) {
                counter[l][n] = (counter[l - 1][n - 1] + counter[l - 1][n + 1]) % MOD;
            }
        }

        int sum = 0;
        for (int count : counter[LEN - 1]) {
            sum += count;
            sum %= MOD;
        }
        result.append(sum);
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