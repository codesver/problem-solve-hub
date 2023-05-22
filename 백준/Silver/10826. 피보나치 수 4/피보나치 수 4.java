import java.io.*;
import java.math.BigInteger;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        if (n == 0) result.append(0);
        else {
            BigInteger[] fibonacci = new BigInteger[n + 1];
            fibonacci[0] = BigInteger.ZERO;
            fibonacci[1] = BigInteger.ONE;
            for(int i = 2; i <= n; i++) fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
            result.append(fibonacci[n]);
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