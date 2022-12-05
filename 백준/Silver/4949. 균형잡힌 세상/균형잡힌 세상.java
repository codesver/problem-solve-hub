import java.io.*;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        String sentence = ".";
        while (!(sentence = reader.readLine()).equals(".")) {
            Stack<Character> brackets = new Stack<>();
            boolean balanced = true;

            for (char bracket : sentence.toCharArray()) {
                if (bracket == '[' || bracket == '(') brackets.push(bracket);
                else if (bracket == ']')
                    if (!brackets.isEmpty() && brackets.peek() == '[') brackets.pop();
                    else {
                        balanced = false;
                        break;
                    }
                else if (bracket == ')')
                    if (!brackets.isEmpty() && brackets.peek() == '(') brackets.pop();
                    else {
                        balanced = false;
                        break;
                    }
            }
            balanced = balanced && brackets.isEmpty();
            result.append(balanced ? "yes" : "no").append("\n");
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