import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int firstNumber = Integer.parseInt(tokenizer.nextToken());
        if (!(firstNumber == 1) && !(firstNumber == 8)) {
            result.append("mixed");
        } else {
            int next = firstNumber == 1 ? 2 : 7;
            int step = firstNumber == 1 ? 1 : -1;
            boolean isSorted = true;

            while (tokenizer.hasMoreTokens()) {
                if (next != Integer.parseInt(tokenizer.nextToken())) {
                    isSorted = false;
                    break;
                }
                next += step;
            }

            result.append(isSorted ? step == 1 ? "ascending" : "descending" : "mixed");
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