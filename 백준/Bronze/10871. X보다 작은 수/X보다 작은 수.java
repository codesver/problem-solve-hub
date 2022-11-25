import java.io.*;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int X = Integer.parseInt(reader.readLine().split(" ")[1]);

        Arrays.stream(reader.readLine().split(" "))
                .forEach(num -> {
                    if (Integer.parseInt(num) < X)
                        result.append(num).append(" ");
                });
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

