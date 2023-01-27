import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        while (T-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int numA = Integer.parseInt(tokenizer.nextToken());
            int numB = Integer.parseInt(tokenizer.nextToken());
            int div = 2;
            int mul = 1;
            while (div <= Math.min(numA, numB)) {
                if (numA % div == 0 && numB % div == 0) {
                    numA /= div;
                    numB /= div;
                    mul *= div;
                } else div++;
            }
            result.append(numA * numB * mul).append("\n");
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