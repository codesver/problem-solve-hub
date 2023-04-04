import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer;
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int distance = -(Integer.parseInt(tokenizer.nextToken()) - Integer.parseInt(tokenizer.nextToken()));
            result.append(warp(distance)).append("\n");
        }
    }

    private int warp(int distance) {
        int move = 1;
        while (true) {
            distance -= (move + 1) / 2;
            if (distance <= 0) return move;
            move++;
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