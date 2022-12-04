import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numA = Integer.parseInt(tokenizer.nextToken());
        int numB = Integer.parseInt(tokenizer.nextToken());

        int divisor = 1;
        for (int i = 2; i <= Math.min(numA, numB); ) {
            if (numA % i == 0 && numB % i == 0) {
                divisor *= i;
                numA /= i;
                numB /= i;
                continue;
            }
            i++;
        }

        result.append(divisor).append("\n").append(divisor * numA * numB);
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