import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    static class Tower {
        int tno, height;

        public Tower(int tno, int height) {
            this.tno = tno;
            this.height = height;
        }
    }

    public void solve() throws IOException {
        int TOWER_NUM = Integer.parseInt(reader.readLine());
        Stack<Tower> towers = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int t = 1; t <= TOWER_NUM; t++) {
            int height = Integer.parseInt(tokenizer.nextToken()), tno = 0;
            while (!towers.isEmpty()) {
                if (towers.peek().height >= height) {
                    tno = towers.peek().tno;
                    break;
                }
                towers.pop();
            }
            result.append(tno).append(' ');
            towers.push(new Tower(t, height));
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