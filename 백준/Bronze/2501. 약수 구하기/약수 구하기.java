import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        for (int d = 1; d <= N; d++) {
            if (N % d == 0) K--;
            if (K == 0) {
                result.append(d);
                break;
            }
        }
        if (K != 0) result.append(0);
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