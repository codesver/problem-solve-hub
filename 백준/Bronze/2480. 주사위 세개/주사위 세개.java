import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numA = Integer.parseInt(tokenizer.nextToken());
        int numB = Integer.parseInt(tokenizer.nextToken());
        int numC = Integer.parseInt(tokenizer.nextToken());

        result.append(numA == numB && numB == numC ?
                10000 + numA * 1000 :
                numA != numB && numB != numC && numC != numA ?
                        Math.max(Math.max(numA, numB), numC) * 100 :
                        1000 + 100 * (numA == numB ? numA : numC)
        );
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
