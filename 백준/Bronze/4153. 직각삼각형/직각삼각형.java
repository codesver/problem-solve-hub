import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        String line;
        while (!(line = reader.readLine()).equals("0 0 0")) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            int sum = 0, max = Integer.MIN_VALUE;
            while (tokenizer.hasMoreTokens()) {
                int num = (int) Math.pow(Integer.parseInt(tokenizer.nextToken()), 2);
                sum += num;
                max = Math.max(max, num);
            }
            result.append(sum - max == max ? "right" : "wrong").append("\n");
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