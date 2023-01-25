import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        while (T-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int W = Integer.parseInt(tokenizer.nextToken());
            int E = Integer.parseInt(tokenizer.nextToken());
            if (W == E) {
                result.append(1);
            } else {
                BigInteger parent = BigInteger.ONE;
                for (int i = Math.max(E - W, W) + 1; i <= E; i++) parent = parent.multiply(BigInteger.valueOf(i));

                BigInteger child = BigInteger.ONE;
                for (int i = 1; i <= Math.min(E - W, W); i++) child = child.multiply(BigInteger.valueOf(i));
                result.append(parent.divide(child));
            }
            result.append("\n");
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