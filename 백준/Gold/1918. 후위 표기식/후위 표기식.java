import java.io.*;
import java.util.Stack;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        Stack<Operator> ops = new Stack<>();
        reader.readLine().chars().forEach(ch -> {
            if (Character.isAlphabetic(ch)) result.append((char) ch);
            else if (ch == '(') ops.push(Operator.BRACKET_LEFT);
            else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != Operator.BRACKET_LEFT) result.append(ops.pop().getType());
                ops.pop();
            } else {
                Operator operator = ch == '+' ? Operator.PLUS : ch == '-' ? Operator.MINUS : ch == '*' ? Operator.MUL : Operator.DIV;
                while (!ops.isEmpty() && ops.peek().getPriority() >= operator.getPriority())
                    result.append(ops.pop().getType());
                ops.push(operator);
            }
        });
        while (!ops.isEmpty()) result.append(ops.pop().getType());
    }

    public void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}

enum Operator {

    BRACKET_LEFT('(', 0), BRACKET_RIGHT(')', 0),
    PLUS('+', 1), MINUS('-', 1),
    MUL('*', 2), DIV('/', 2);

    final char type;
    final int priority;

    Operator(char type, int priority) {
        this.type = type;
        this.priority = priority;
    }

    public char getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }
}