import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int sum = A + B;

        Set<Integer> set = new HashSet<>();

        tokenizer = new StringTokenizer(reader.readLine());
        while (A-- > 0) set.add(Integer.parseInt(tokenizer.nextToken()));
        tokenizer = new StringTokenizer(reader.readLine());
        while (B-- > 0) set.add(Integer.parseInt(tokenizer.nextToken()));

        result.append(set.size() * 2 - sum);
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