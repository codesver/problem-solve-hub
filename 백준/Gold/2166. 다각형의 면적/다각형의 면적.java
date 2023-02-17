import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        List<Point> points = new ArrayList<>();
        while (N-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            points.add(new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }
        points.add(points.get(0));

        long sumA = 0, sumB = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point pa = points.get(i);
            Point pb = points.get(i + 1);
            sumA += pa.x * pb.y;
            sumB += pa.y * pb.x;
        }
        result.append(String.format("%.1f", Math.abs(sumA - sumB) / 2.0));
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

class Point {

    long x, y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}