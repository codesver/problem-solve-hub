import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int min = Integer.parseInt(tokenizer.nextToken());
        int max = Integer.parseInt(tokenizer.nextToken());

        boolean[] isNotPrime = new boolean[max + 1];
        for (int num = 2; num <= max; num++) {
            if (!isNotPrime[num]) {
                if (num >= min) result.append(num).append("\n");
                int index = num;
                while ((index += num) <= max) isNotPrime[index] = true;
            }
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