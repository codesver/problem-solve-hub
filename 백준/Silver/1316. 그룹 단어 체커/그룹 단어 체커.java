import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int repeat = Integer.parseInt(reader.readLine());
        int count = 0;

        OuterLoop:
        while (repeat-- > 0) {
            String word = reader.readLine();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                int start = word.indexOf(ch);
                int end = word.lastIndexOf(ch);
                if (start == -1 || start == end || start + 1 == end) continue;
                if (!word.substring(start, end + 1).matches(ch + "+")) continue OuterLoop;
            }
            count++;
        }

        result.append(count);
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