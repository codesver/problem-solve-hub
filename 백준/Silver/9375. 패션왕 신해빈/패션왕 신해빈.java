import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            Map<String, Integer> clothes = new HashMap<>();
            int CLOTHES = Integer.parseInt(reader.readLine());
            while (CLOTHES-- > 0) clothes.merge(reader.readLine().split(" ")[1], 1, Integer::sum);
            int count = 1;
            for (Integer num : clothes.values()) count *= num + 1;
            result.append(count - 1).append("\n");
        }
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