import java.io.*;
import java.util.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(tokenizer.nextToken());
        int col = Integer.parseInt(tokenizer.nextToken());
        List<Integer> nums = new LinkedList<>(Arrays.asList(0, 1, 0));
        while (row-- > 1) {
            int size = nums.size() - 2;
            nums.add(0);
            for(int i = 0; i <= size; i++) nums.add(nums.remove(0) + nums.get(0));
            nums.add(nums.remove(0));
        }
        result.append(nums.get(col));
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