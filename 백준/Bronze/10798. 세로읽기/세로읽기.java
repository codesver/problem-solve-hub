import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            String string = reader.readLine();
            IntStream.range(0, string.length())
                    .forEach(j -> map.put(j, map.getOrDefault(j, "") + string.charAt(j)));
        }
        result.append(String.join("", map.values()));
    }

    public void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}