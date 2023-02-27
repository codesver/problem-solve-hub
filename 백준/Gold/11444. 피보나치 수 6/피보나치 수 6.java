import java.io.*;
import java.math.BigInteger;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public final int MOD = 1_000_000_007;

    public void solve() throws IOException {
        BigInteger N = new BigInteger(reader.readLine());
        long fn = fibonacci(new long[][]{{1, 1}, {1, 0}}, N);
        result.append(fn);
    }

    private long fibonacci(long[][] matrix, BigInteger pow) {
        long[][] m = {{1, 0}, {0, 1}};
        while (pow.compareTo(BigInteger.ZERO) > 0) {
            if (pow.testBit(0)) m = multiply(m, matrix);
            pow = pow.shiftRight(1);
            matrix = multiply(matrix, matrix);
        }
        return m[1][0];
    }

    private long[][] multiply(long[][] ma, long[][] mb) {
        return new long[][]{
                {
                        (ma[0][0] * mb[0][0] % MOD + ma[0][1] * mb[1][0] % MOD) % MOD,
                        (ma[0][0] * mb[0][1] % MOD + ma[0][1] * mb[1][1] % MOD) % MOD
                },
                {
                        (ma[1][0] * mb[0][0] % MOD + ma[1][1] * mb[1][0] % MOD) % MOD,
                        (ma[1][0] * mb[0][1] % MOD + ma[1][1] * mb[1][1] % MOD) % MOD
                }
        };
    }

    private void finish() throws IOException {
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