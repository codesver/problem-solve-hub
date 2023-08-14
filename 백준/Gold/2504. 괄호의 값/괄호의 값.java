import java.io.*;
import java.util.Stack;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        boolean summed = true;
        int sum = 0, mul = 1;
        Stack<Character> stack = new Stack<>();

        for (char parenthesis : reader.readLine().toCharArray()) {
            if (parenthesis == '(' || parenthesis == '[') {
                summed = false;
                stack.push(parenthesis);
                mul *= parenthesis == '(' ? 2 : 3;
            } else {
                if (stack.isEmpty() ||
                        parenthesis == ')' && stack.peek() != '(' ||
                        parenthesis == ']' && stack.peek() != '['
                ) {
                    sum = 0;
                    break;
                }
                if (!summed) {
                    sum += mul;
                    summed = true;
                }
                mul /= parenthesis == ')' ? 2 : 3;
                stack.pop();
            }
        }

        result.append(stack.isEmpty() ? sum : 0);
    }

    public void submit() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.submit();
    }
}