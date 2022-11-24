import java.io.*;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int numA = Integer.parseInt(reader.readLine());
        IntStream.rangeClosed(1, 9)
                .forEach(numB -> result
                        .append(numA)
                        .append(" * ")
                        .append(numB)
                        .append(" = ")
                        .append(numA * numB)
                        .append("\n"));
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
