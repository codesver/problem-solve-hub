import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        List<Integer> nums = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        int index = 0;
        result.append("<");
        while (!nums.isEmpty()) {
            index += k - 1;
            index %= nums.size();
            result.append(nums.remove(index)).append(", ");
        }
        result.replace(result.length() - 2, result.length(), ">");
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