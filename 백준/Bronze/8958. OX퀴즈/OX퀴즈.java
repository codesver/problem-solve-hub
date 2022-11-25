import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int repeat = Integer.parseInt(reader.readLine());
        while (repeat-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), "X");
            int sum = 0;
            while (tokenizer.hasMoreTokens()) {
                int length = tokenizer.nextToken().length();
                sum += (length * (length + 1)) / 2;
            }
            result.append(sum).append("\n");
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

