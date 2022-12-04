import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        while (tokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(tokenizer.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens())
            result.append(map.getOrDefault(Integer.parseInt(tokenizer.nextToken()), 0))
                    .append(" ");
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