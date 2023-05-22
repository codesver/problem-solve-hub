import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int[] nums = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        String A = reader.readLine();
        String B = reader.readLine();
        List<Integer> sums = new LinkedList<>();
        for (int i = 0; i < A.length(); i++) {
            sums.add(nums[A.charAt(i) - 65]);
            sums.add(nums[B.charAt(i) - 65]);
        }
        while (sums.size() > 2) {
            int size = sums.size() - 1;
            for (int i = 0; i < size; i++) sums.add((sums.remove(0) + sums.get(0)) % 10);
            sums.remove(0);
        }
        result.append(sums.get(0)).append(sums.get(1));
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