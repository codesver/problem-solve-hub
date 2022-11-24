import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int total = Integer.parseInt(reader.readLine());
        int num = Integer.parseInt(reader.readLine());
        int sum = 0;
        while (num-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            sum += Integer.parseInt(tokenizer.nextToken()) * Integer.parseInt(tokenizer.nextToken());
        }
        result.append(total == sum ? "Yes" : "No");
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
