import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int repeat = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (repeat-- > 0) {
            int num = Integer.parseInt(tokenizer.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        result.append(min).append(" ").append(max);
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

