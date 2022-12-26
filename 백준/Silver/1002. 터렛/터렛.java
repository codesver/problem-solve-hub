import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int r1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());
            int r2 = Integer.parseInt(tokenizer.nextToken());

            int distance = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if (x1 == x2 && y1 == y2 && r1 == r2) result.append(-1);
            else if (distance > Math.pow(r1 + r2, 2) || distance < Math.pow(r1 - r2, 2)) result.append(0);
            else if (distance == Math.pow(r1 - r2, 2) || distance == Math.pow(r1 + r2, 2)) result.append(1);
            else result.append(2);
            result.append("\n");
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