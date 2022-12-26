import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer;
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            Point start = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
            Point end = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

            int count = 0;
            int planetsNum = Integer.parseInt(reader.readLine());
            while (planetsNum-- > 0) {
                tokenizer = new StringTokenizer(reader.readLine());
                Planets planets = new Planets(Integer.parseInt(tokenizer.nextToken()),
                        Integer.parseInt(tokenizer.nextToken()),
                        Integer.parseInt(tokenizer.nextToken()));
                if (start.isInside(planets) != end.isInside(planets)) count++;
            }

            result.append(count).append("\n");
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isInside(Planets planets) {
            return Math.pow(x - planets.cx, 2) + Math.pow(y - planets.cy, 2) < Math.pow(planets.r, 2);
        }
    }

    static class Planets {
        int cx, cy, r;

        public Planets(int cx, int cy, int r) {
            this.cx = cx;
            this.cy = cy;
            this.r = r;
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