import java.io.*;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        String[] split = reader.readLine().split("-");
        int sum = Arrays.stream(split[0].split("\\+")).mapToInt(Integer::parseInt).sum();
        for (int i = 1; i < split.length; i++)
            sum -= Arrays.stream(split[i].split("\\+")).mapToInt(Integer::parseInt).sum();
        result.append(sum);
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