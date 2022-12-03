import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Set<Integer> set = new HashSet<>();

        String n = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) set.add(Integer.parseInt(tokenizer.nextToken()));

        String m = reader.readLine();
        tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens())
            result.append(set.contains(Integer.parseInt(tokenizer.nextToken())) ? 1 : 0).append("\n");
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