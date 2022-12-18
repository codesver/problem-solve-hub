import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int value = Integer.parseInt(tokenizer.nextToken());

        Stack<Integer> coins = new Stack<>();
        while (N-- > 0) coins.add(Integer.parseInt(reader.readLine()));

        int count = 0;
        while (!coins.isEmpty()) {
            Integer coin = coins.pop();
            count += value / coin;
            value %= coin;
        }

        result.append(count);
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