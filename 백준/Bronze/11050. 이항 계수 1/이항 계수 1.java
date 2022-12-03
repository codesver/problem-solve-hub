import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int up = 1, down = 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i <= k) down *= i;
            if (count++ < k) up *= n - i + 1;
        }
        result.append(up / down);
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