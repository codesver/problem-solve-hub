import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Queue<Integer> xes = new PriorityQueue<>(Comparator.reverseOrder());
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            int x = Integer.parseInt(reader.readLine());
            if (x == 0) result.append(xes.isEmpty() ? 0 : xes.poll()).append("\n");
            else xes.add(x);
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