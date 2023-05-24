import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer;
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int size = Integer.parseInt(reader.readLine());
            tokenizer = new StringTokenizer(reader.readLine());
            int sum = 0, maxSum = -1000_000;
            while (size-- > 0) {
                int num = Integer.parseInt(tokenizer.nextToken());
                sum = Math.max(sum + num, num);
                maxSum = Math.max(maxSum, sum);
            }
            result.append(maxSum).append('\n');
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