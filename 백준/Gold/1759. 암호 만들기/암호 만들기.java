import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    int LEN;
    char[] chars;
    Stack<Character> password = new Stack<>();

    public void solve() throws IOException {
        init();
        search(0, 0);
    }

    private void search(int index, int vowelNum) {
        if (password.size() == LEN) {
            if (vowelNum >= 1 && LEN - vowelNum >= 2)
                result.append(password.stream().map(String::valueOf).collect(Collectors.joining()))
                        .append("\n");
        } else for (int i = index; i < chars.length; i++) {
            password.push(chars[i]);
            search(i + 1, vowels.contains(chars[i]) ? vowelNum + 1 : vowelNum);
            password.pop();
        }
    }

    private void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        LEN = Integer.parseInt(tokenizer.nextToken());
        int charNum = Integer.parseInt(tokenizer.nextToken());
        chars = reader.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(chars);
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