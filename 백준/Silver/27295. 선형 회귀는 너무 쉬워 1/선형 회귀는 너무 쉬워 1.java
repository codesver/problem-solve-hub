
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long n = Long.parseLong(tokenizer.nextToken());
        long b = Long.parseLong(tokenizer.nextToken());

        long p = -n * b, q = 0;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            q += Long.parseLong(tokenizer.nextToken());
            p += Long.parseLong(tokenizer.nextToken());
        }

        long gcd = gcd(p, q);
        if (gcd != 0) {
            p /= gcd;
            q /= gcd;
        }
        if (q < 0) {
            p *= -1;
            q *= -1;
        }

        if (q == 0) result.append("EZPZ");
        else if (q == 1) result.append(p);
        else result.append(p).append('/').append(q);
    }

    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public void submit() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.submit();
    }
}