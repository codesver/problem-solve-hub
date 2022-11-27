import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int max = Integer.MIN_VALUE;
        int row = 0, col = 0;
        for (int r = 1; r <= 9; r++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 1; c <= 9; c++) {
                int num = Integer.parseInt(tokenizer.nextToken());
                if (num > max) {
                    max = num;
                    row = r;
                    col = c;
                }
            }
        }
        result.append(max).append("\n").append(row).append(" ").append(col);
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