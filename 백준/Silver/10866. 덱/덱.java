import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int line = Integer.parseInt(reader.readLine());
        Deque<Integer> deque = new LinkedList<>();
        while (line-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            if (command.equals("push_front")) deque.addFirst(Integer.parseInt(tokenizer.nextToken()));
            else if (command.equals("push_back")) deque.addLast(Integer.parseInt(tokenizer.nextToken()));
            else if (command.equals("pop_front")) result.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            else if (command.equals("pop_back")) result.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            else if (command.equals("size")) result.append(deque.size()).append("\n");
            else if (command.equals("empty")) result.append(deque.isEmpty() ? 1 : 0).append("\n");
            else if (command.equals("front")) result.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            else if (command.equals("back")) result.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
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