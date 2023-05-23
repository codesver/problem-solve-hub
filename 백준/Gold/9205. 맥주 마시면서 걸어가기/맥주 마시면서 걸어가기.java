import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer;
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            Queue<Point> pointsArrived = new LinkedList<>();
            List<Point> pointsNotArrived = new LinkedList<>();

            int marketNum = Integer.parseInt(reader.readLine());
            tokenizer = new StringTokenizer(reader.readLine());
            Point start = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
            pointsArrived.offer(start);

            while (marketNum-- > 0) {
                tokenizer = new StringTokenizer(reader.readLine());
                Point market = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                pointsNotArrived.add(market);
            }

            tokenizer = new StringTokenizer(reader.readLine());
            Point end = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()), true);
            pointsNotArrived.add(end);

            result.append(canArriveFestival(pointsArrived, pointsNotArrived) ? "happy" : "sad").append('\n');
        }
    }

    private boolean canArriveFestival(Queue<Point> pointsArrived, List<Point> pointsNotArrived) {
        while (!pointsArrived.isEmpty()) {
            Point point = pointsArrived.poll();
            for (int p = 0; p < pointsNotArrived.size(); p++) {
                Point nextPoint = pointsNotArrived.get(p);
                if (point.distance(nextPoint) <= 1000)
                    if (nextPoint.isFestival()) return true;
                    else pointsArrived.add(pointsNotArrived.remove(p--));
            }
        }
        return false;
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

    private final int x, y;
    private boolean festival;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, boolean festival) {
        this.x = x;
        this.y = y;
        this.festival = festival;
    }

    public int distance(Point point) {
        return Math.abs(x - point.x) + Math.abs(y - point.y);
    }

    public boolean isFestival() {
        return festival;
    }
}