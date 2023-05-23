import java.io.*;
import java.util.Arrays;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(("0 " + reader.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ascending = new int[size + 1];
        int[] descending = new int[size + 1];
        int max = 0;
        for(int i = 1; i <= size; i++) {
            ascending[i] = nums[i] >= nums[i - 1] ? ascending[i - 1] + 1 : 1;
            descending[i] = nums[i] <= nums[i - 1] ? descending[i - 1] + 1 : 1;
            max = Math.max(max, Math.max(ascending[i], descending[i]));
        }
        result.append(max);
    }

    public void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}