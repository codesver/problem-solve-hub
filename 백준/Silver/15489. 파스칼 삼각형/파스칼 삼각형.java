import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());
        int W = Integer.parseInt(tokenizer.nextToken());

        int sum = 0;
        List<Integer> nums = new LinkedList<>();
        for (int h = 1; h < R + W; h++) {
            if (h == 1) nums.addAll(Arrays.asList(0, 1, 0));
            else {
                nums.add(0);
                for (int w = 0; w < h; w++) nums.add((int) nums.remove(0) + nums.get(0));
                nums.add(nums.remove(0));
            }
            if (h >= R) sum += nums.subList(C, C + 1 + h - R).stream().mapToInt(Integer::intValue).sum();
        }
        result.append(sum);
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