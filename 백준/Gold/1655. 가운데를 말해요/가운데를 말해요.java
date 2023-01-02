import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            int num = Integer.parseInt(reader.readLine());

            if (max.size() == min.size()) max.add(num);
            else min.add(num);

            if (!min.isEmpty() && !max.isEmpty() && min.peek() < max.peek()) {
                min.add(max.poll());
                max.add(min.poll());
            }

            result.append(max.peek()).append("\n");
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