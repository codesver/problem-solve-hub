import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Deque<Integer> queue = new LinkedList<>();
        StringTokenizer tokenizer;
        int commandNum = Integer.parseInt(reader.readLine());
        while (commandNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            if (command.equals("push")) queue.addLast(Integer.parseInt(tokenizer.nextToken()));
            else if (command.equals("pop")) result.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n");
            else if (command.equals("size")) result.append(queue.size()).append("\n");
            else if (command.equals("empty")) result.append(queue.isEmpty() ? 1 : 0).append("\n");
            else if (command.equals("front")) result.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
            else if (command.equals("back")) result.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
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