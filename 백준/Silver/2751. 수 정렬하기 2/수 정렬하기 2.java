import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int repeat = Integer.parseInt(reader.readLine());
        Queue<Integer> nums = new PriorityQueue<>();
        while (repeat-- > 0) nums.add(Integer.parseInt(reader.readLine()));
        while (!nums.isEmpty()) result.append(nums.poll()).append("\n");
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