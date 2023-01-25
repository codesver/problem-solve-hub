import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());

        int sum = 0;
        int length = N + 1;
        Queue<Integer> nums = new LinkedList<>();
        while (tokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(tokenizer.nextToken());
            sum += num;
            nums.add(num);

            while (!nums.isEmpty() && sum - nums.peek() >= S) sum -= nums.poll();

            if (sum >= S) length = Math.min(length, nums.size());
        }

        result.append(length == N + 1 ? 0 : length);
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