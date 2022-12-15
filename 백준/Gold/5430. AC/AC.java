import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int test = Integer.parseInt(reader.readLine());
        testCase:
        while (test-- > 0) {
            // READ
            char[] commands = reader.readLine().toCharArray();
            int size = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), "[],");

            Deque<Integer> deque = new LinkedList<>();
            while (size-- > 0) deque.addLast(Integer.parseInt(tokenizer.nextToken()));
            boolean type = true;

            for (char command : commands)
                if (command == 'R') type = !type;
                else if (command == 'D')
                    if (deque.size() == 0) {
                        result.append("error").append("\n");
                        continue testCase;
                    }
                    else if (type) deque.pollFirst();
                    else deque.pollLast();

            result.append("[");
            while (!deque.isEmpty()) {
                if (type) result.append(deque.pollFirst());
                else result.append(deque.pollLast());
                if (!deque.isEmpty()) result.append(",");
            }
            result.append("]").append("\n");
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