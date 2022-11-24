import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        String word = reader.readLine().toUpperCase();
        Map<String, Long> map = Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String maxKey = "null";
        long maxValue = Long.MIN_VALUE;
        for (String key : map.keySet())
            if (map.get(key) > maxValue) {
                maxKey = key;
                maxValue = map.get(key);
            }

        final long finalValue = maxValue;
        long count = map.values().stream().filter(value -> value == finalValue).count();

        result.append(count == 1 ? maxKey : "?");
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
