import java.io.*;
import java.math.BigInteger;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        if (N <= 3) result.append(1);
        else {
            BigInteger[] fibonacci = new BigInteger[N + 1];
            fibonacci[1] = fibonacci[2] = fibonacci[3] = BigInteger.ONE;
            for (int n = 4; n <= N; n++) fibonacci[n] = fibonacci[n - 1].add(fibonacci[n - 3]);
            result.append(fibonacci[N]);
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