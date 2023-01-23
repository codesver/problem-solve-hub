import java.io.*;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        final int MAX = 10_001;
        boolean[] primes = new boolean[MAX];
        Arrays.fill(primes, true);
        primes[1] = false;
        for (int num = 2; num < MAX; num++) {
            if (primes[num]) {
                for (int n = num * 2; n < MAX; n += num) {
                    primes[n] = false;
                }
            }
        }

        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            for (int i = N / 2; i > 1; i--) {
                if (primes[i] && primes[N - i]) {
                    result.append(i).append(" ").append(N - i).append("\n");
                    break;
                }
            }
        }
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