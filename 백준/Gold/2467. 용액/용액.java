import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        Deque<Integer> nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        int left = 0, right = 0, sum = Integer.MAX_VALUE;
        while (nums.size() >= 2) {
            int min = nums.peekFirst();
            int max = nums.peekLast();
            if (min + max == 0) {
                left = min;
                right = max;
                break;
            }
            if (sum > Math.abs(min + max)) {
                sum = Math.abs(min + max);
                left = min;
                right = max;
                continue;
            }
            if (min + max > 0) nums.pollLast();
            else if (min + max < 0) nums.pollFirst();
        }
        result.append(left).append(" ").append(right);
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