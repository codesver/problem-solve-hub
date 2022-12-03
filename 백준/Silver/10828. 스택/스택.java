import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();
        while (size-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            if (command.equals("push")) stack.push(Integer.parseInt(tokenizer.nextToken()));
            else if (command.equals("pop")) result.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            else if (command.equals("size")) result.append(stack.size()).append("\n");
            else if (command.equals("empty")) result.append(stack.isEmpty() ? 1 : 0).append("\n");
            else if (command.equals("top")) result.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
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