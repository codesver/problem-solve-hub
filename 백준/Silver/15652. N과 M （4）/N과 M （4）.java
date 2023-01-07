import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int N, M;

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        IntStream.rangeClosed(1, N).forEach(Main::deeper);
    }

    private static void deeper(int... nums) {
        if (nums.length == M) {
            Arrays.stream(nums).forEach(num -> result.append(num).append(" "));
            result.append("\n");
        } else {
            IntStream.rangeClosed(nums[nums.length - 1], N).forEach(num -> {
                int[] copied = Arrays.copyOf(nums, nums.length + 1);
                copied[nums.length] = num;
                deeper(copied);
            });
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