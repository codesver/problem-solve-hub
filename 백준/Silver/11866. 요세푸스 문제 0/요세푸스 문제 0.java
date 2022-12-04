import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int max = Integer.parseInt(tokenizer.nextToken());
        int step = Integer.parseInt(tokenizer.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        IntStream.rangeClosed(1, max).forEach(queue::add);

        result.append("<");
        while (!queue.isEmpty()) {
            IntStream.range(0, step - 1).forEach(index -> queue.add(queue.poll()));
            result.append(queue.poll()).append(", ");
        }
        result.delete(result.length() - 2, result.length()).append(">");
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