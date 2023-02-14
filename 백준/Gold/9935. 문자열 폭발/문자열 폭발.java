import java.io.*;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    public static void solution() throws IOException {
        String string = reader.readLine();
        String bomb = reader.readLine();

        Stack<Character> chs = new Stack<>();
        Loop:
        for (char ch : string.toCharArray()) {
            chs.push(ch);
            if (chs.size() >= bomb.length()) {
                int start = chs.size() - bomb.length();
                for (int i = start; i < chs.size(); i++)
                    if (bomb.charAt(i - start) != chs.get(i)) continue Loop;
                IntStream.range(0, bomb.length()).forEach(i -> chs.pop());
            }
        }

        String after = chs.stream().map(String::valueOf).collect(Collectors.joining());
        result.append(after.isEmpty() ? "FRULA" : after);
    }

    public static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}