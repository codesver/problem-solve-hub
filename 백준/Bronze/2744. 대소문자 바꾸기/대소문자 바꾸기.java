import java.io.*;
import java.util.stream.Collectors;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        result.append(reader.readLine().chars().mapToObj(ch -> {
            if (Character.isUpperCase(ch)) return String.valueOf((char) Character.toLowerCase(ch));
            else return String.valueOf((char) Character.toUpperCase(ch));
        }).collect(Collectors.joining()));
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