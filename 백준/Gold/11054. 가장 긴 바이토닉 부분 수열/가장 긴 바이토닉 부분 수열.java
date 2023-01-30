import java.io.*;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int L = Integer.parseInt(reader.readLine());
        int[] left = new int[L];
        int[] right = new int[L];
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < L; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }

                if (nums[L - j - 1] < nums[L - i - 1]) {
                    right[L - i - 1] = Math.max(right[L - i - 1], right[L - j - 1] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < L; i++) max = Math.max(max, left[i] + right[i]);
        result.append(max - 1);
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