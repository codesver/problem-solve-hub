import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private Map<Integer, BigInteger> memory = new HashMap<>();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        BigInteger[] ts = new BigInteger[N + 1];
        ts[0] = BigInteger.ONE;
        for (int n = 1; n <= N; n++) {
            ts[n] = BigInteger.ZERO;
            for (int i = 0; i < n; i++) ts[n] = ts[n].add(ts[i].multiply(ts[n - i - 1]));
        }
        result.append(ts[N]);
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