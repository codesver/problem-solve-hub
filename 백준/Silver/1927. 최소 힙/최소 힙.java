import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Queue<Integer> queue = new PriorityQueue<>();
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            int number = Integer.parseInt(reader.readLine());
            if (number == 0) result.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
            else queue.add(number);
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