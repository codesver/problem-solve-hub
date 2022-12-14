import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int nameNum = Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken());
        
        Set<String> names = new HashSet<>();
        Queue<String> offNames = new PriorityQueue<>(String::compareTo);
        while (nameNum-- > 0) {
            String name = reader.readLine();
            if (names.contains(name)) offNames.add(name);
            else names.add(name);
        }
        result.append(offNames.size()).append("\n");
        while (!offNames.isEmpty()) result.append(offNames.poll()).append("\n");
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