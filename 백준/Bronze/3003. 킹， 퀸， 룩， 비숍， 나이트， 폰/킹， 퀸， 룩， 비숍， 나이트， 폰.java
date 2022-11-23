import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        List<Integer> fulls = Arrays.asList(1, 1, 2, 2, 2, 8);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (Integer full : fulls) {
            result.append(full - Integer.parseInt(tokenizer.nextToken())).append(" ");
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
