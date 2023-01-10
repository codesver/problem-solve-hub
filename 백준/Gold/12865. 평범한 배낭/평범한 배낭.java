import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        final int ITEM_NUM = Integer.parseInt(tokenizer.nextToken());
        final int MAX_WEIGHT = Integer.parseInt(tokenizer.nextToken());

        final int[] weights = new int[ITEM_NUM + 1];
        final int[] values = new int[ITEM_NUM + 1];
        final int[] dp = new int[MAX_WEIGHT + 1];

        for (int ino = 1; ino <= ITEM_NUM; ino++) {
            tokenizer = new StringTokenizer(reader.readLine());
            weights[ino] = Integer.parseInt(tokenizer.nextToken());
            values[ino] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int ino = 1; ino <= ITEM_NUM; ino++) {
            for (int w = MAX_WEIGHT; w - weights[ino] >= 0; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[ino]] + values[ino]);
            }
        }

        result.append(dp[MAX_WEIGHT]);
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