import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), "-");
        int sum = Arrays.stream(tokenizer.nextToken().split("\\+")).mapToInt(Integer::parseInt).sum();
        while (tokenizer.hasMoreTokens())
            sum -= Arrays.stream(tokenizer.nextToken().split("\\+")).mapToInt(Integer::parseInt).sum();
        result.append(sum);
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