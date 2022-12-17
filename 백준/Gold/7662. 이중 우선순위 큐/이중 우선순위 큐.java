import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            TreeMap<Integer, Integer> Q = new TreeMap<>();
            StringTokenizer tokenizer;

            int operations = Integer.parseInt(reader.readLine());
            while (operations-- > 0) {
                tokenizer = new StringTokenizer(reader.readLine());
                if (tokenizer.nextToken().equals("I"))
                    Q.merge(Integer.parseInt(tokenizer.nextToken()), 1, Integer::sum);
                else if (!Q.isEmpty()) {
                    Integer data = Integer.parseInt(tokenizer.nextToken()) == 1 ?
                            Q.lastKey() :
                            Q.firstKey();
                    if (Q.get(data) > 1) Q.merge(data, -1, Integer::sum);
                    else Q.remove(data);
                }
            }

            result.append(Q.isEmpty() ? "EMPTY" : Q.lastKey() + " " + Q.firstKey())
                    .append("\n");
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