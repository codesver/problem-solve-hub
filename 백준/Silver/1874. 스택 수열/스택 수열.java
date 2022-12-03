import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int repeat = n;
        Queue<Integer> queue = new LinkedList<>();
        while (repeat-- > 0) queue.add(Integer.parseInt(reader.readLine()));

        Stack<Integer> stack = new Stack<>();
        for (int num = 1; num <= n; num++) {
            stack.push(num);
            result.append("+").append("\n");
            while (!stack.isEmpty() && stack.peek().equals(queue.peek())) {
                stack.pop();
                queue.poll();
                result.append("-").append("\n");
            }
        }

        if (!queue.isEmpty()) result.delete(0, result.length()).append("NO");
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