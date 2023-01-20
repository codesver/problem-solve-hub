import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int maxLeft = 0, maxRight = 0;
        int sumLeft = 0, sumRight = 0;

        while (tokenizer.hasMoreTokens()) {
            if (Integer.parseInt(tokenizer.nextToken()) == 1) {
                sumLeft = Math.max(sumLeft + 1, 1);
                maxLeft = Math.max(maxLeft, sumLeft);
                sumRight--;
            } else {
                sumRight = Math.max(sumRight + 1, 1);
                maxRight = Math.max(maxRight, sumRight);
                sumLeft--;
            }
        }
        
        result.append(Math.max(maxLeft, maxRight));
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