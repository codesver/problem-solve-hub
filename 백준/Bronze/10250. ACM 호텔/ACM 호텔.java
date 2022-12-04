import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int test = Integer.parseInt(reader.readLine());
        while (test-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int H = Integer.parseInt(tokenizer.nextToken());
            int W = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());
            int front = N % H;
            int back = front == 0 ? N / H : N / H + 1;
            result.append(front == 0 ? H : front).append(back / 10 == 0 ? "0" + back : back).append("\n");
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