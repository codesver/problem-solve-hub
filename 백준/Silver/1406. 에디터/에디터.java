import java.io.*;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        String string = reader.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (char ch : string.toCharArray()) left.push(ch);

        int C = Integer.parseInt(reader.readLine());
        while (C-- > 0) {
            String commandLine = reader.readLine();
            char command = commandLine.charAt(0);
            if (command == 'L' && !left.isEmpty()) right.push(left.pop());
            else if (command == 'D' && !right.isEmpty()) left.push(right.pop());
            else if (command == 'B' && !left.isEmpty()) left.pop();
            else if (command == 'P') left.push(commandLine.charAt(2));
        }
        for (Character ch : left) result.append(ch);
        while (!right.isEmpty()) result.append(right.pop());
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