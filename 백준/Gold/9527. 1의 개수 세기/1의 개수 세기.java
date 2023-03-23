import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long from = Long.parseLong(tokenizer.nextToken());
        long to = Long.parseLong(tokenizer.nextToken());
        result.append(count(to) - count(from - 1));
    }

    private long count(long num) {
        long count = 0;
        int len = Long.toString(num, 2).length();
        for (long i = 1; i <= len; i++) {
            long ca = ((num + 1) / (long) Math.pow(2, i)) * (long) Math.pow(2, i - 1);
            long cb = ((num + 1) % (long) Math.pow(2, i)) - (long) Math.pow(2, i - 1);
            count += ca + Math.max(cb, 0);
        }
        return count;
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