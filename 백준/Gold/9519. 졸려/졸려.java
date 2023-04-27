import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        Map<Integer, String> map = new HashMap<>();
        int X = Integer.parseInt(reader.readLine());
        String string = reader.readLine();
        map.put(0, string);
        for (int x = 1; x <= X; x++) {
            StringBuilder pre = new StringBuilder();
            for (int i = 0; i < string.length(); i += 2) pre.append(string.charAt(i));
            StringBuilder post = new StringBuilder();
            for (int i = 1; i < string.length(); i += 2) post.append(string.charAt(i));
            string = pre.append(post.reverse()).toString();
            if (map.get(0).equals(string)) {
                string = map.get(X % x);
                break;
            }
            map.put(x, string);
        }
        result.append(string);
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