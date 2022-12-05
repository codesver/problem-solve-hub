import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        List<Integer> nums = new ArrayList<>();
        int K = Integer.parseInt(reader.readLine());
        while (K-- > 0) {
            int num = Integer.parseInt(reader.readLine());
            if (num == 0) nums.remove(nums.size() - 1);
            else nums.add(num);
        }
        result.append(nums.stream().mapToInt(Integer::intValue).sum());
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