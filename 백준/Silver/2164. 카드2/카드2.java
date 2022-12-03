import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        Queue<Integer> queue = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toCollection(LinkedList::new));
        boolean type = true;
        while (queue.size() != 1) {
            if (type) queue.poll();
            else queue.add(queue.poll());
            type = !type;
        }
        result.append(queue.poll());
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