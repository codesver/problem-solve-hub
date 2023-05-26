import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int len = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int maxDiff = 0, minNum = Integer.parseInt(tokenizer.nextToken());
        result.append('0').append(' ');
        while (len-- > 1) {
            int num = Integer.parseInt(tokenizer.nextToken());
            maxDiff = Math.max(maxDiff, num - minNum);
            minNum = Math.min(minNum, num);
            result.append(maxDiff).append(' ');
        }
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