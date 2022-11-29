import java.io.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());

        Set<String> set = new HashSet<>();
        Queue<String> words = new PriorityQueue<>(
                (o1, o2) -> o1.length() != o2.length() ?
                        o1.length() - o2.length() :
                        o1.compareTo(o2));

        while (size-- > 0) {
            String word = reader.readLine();
            if (!set.contains(word)) {
                words.add(word);
                set.add(word);
            }
        }
        while (!words.isEmpty()) result.append(words.poll()).append("\n");
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