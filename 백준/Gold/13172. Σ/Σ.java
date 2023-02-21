import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public final int MOD = 1_000_000_007;
    public final Map<Integer, Long> map = new HashMap<>();

    public void solve() throws IOException {
        int M = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        int S, N;
        long sum = 0;
        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            S = Integer.parseInt(tokenizer.nextToken());
            sum += (S * power(N, MOD - 2)) % MOD;
        }
        result.append(sum % MOD);
    }

    public long power(long n, long m) {
        long ret = 1;
        while (m > 0) {
            if (m % 2 == 1) ret = ret * n % MOD;
            m /= 2;
            n = n * n % MOD;
        }
        return ret;
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