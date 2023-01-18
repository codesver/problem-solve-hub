import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int x = 0, y = 0;
        StringTokenizer tokenizer;
        for (int s = 1; s <= 3; s++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int tx = Integer.parseInt(tokenizer.nextToken());
            int ty = Integer.parseInt(tokenizer.nextToken());
            x = calc(s, x, tx);
            y = calc(s, y, ty);
        }
        result.append(x).append(" ").append(y);
    }

    private static int calc(int step, int cur, int temp) {
        return step == 1 ? temp :
                step == 2 ? (cur == temp ? 2001 : cur + temp) :
                        step == 3 ? (cur == 2001 ? temp : cur - temp) :
                                0;
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