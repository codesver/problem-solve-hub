import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        String in = reader.readLine();
        List<String> out = new ArrayList<>();

        if (in.equals("::")) {
            Stream.generate(() -> "0000").limit(8).forEach(out::add);
        } else if (in.startsWith("::")) {
            String[] parts = in.substring(2).split(":");
            Stream.generate(() -> "0000").limit(8 - parts.length).forEach(out::add);
            for (String part : parts) out.add("0".repeat(4 - part.length()) + part);
        } else if (in.endsWith("::")) {
            String[] parts = in.substring(0, in.length() - 2).split(":");
            for (String part : parts) out.add("0".repeat(4 - part.length()) + part);
            Stream.generate(() -> "0000").limit(8 - parts.length).forEach(out::add);
        } else {
            String[] parts = in.split(":");
            for (String part : parts) {
                if (part.length() == 0) {
                    Stream.generate(() -> "0000").limit(9 - parts.length).forEach(out::add);
                } else {
                    out.add("0".repeat(4 - part.length()) + part);
                }
            }
        }

        result.append(String.join(":", out));
    }

    public void submit() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.submit();
    }
}