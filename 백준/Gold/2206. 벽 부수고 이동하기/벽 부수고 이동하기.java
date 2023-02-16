import java.io.*;
import java.util.*;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public int R, C;
    public int[][] map;
    public boolean[][][] visited;
    public int[] moveR = {-1, 0, 1, 0}, moveC = {0, 1, 0, -1};

    public void solve() throws IOException {
        init();
        result.append(search());
    }

    public void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[R + 2][C + 2][2];
        map = new int[R + 2][C + 2];
        for (int[] m : map) Arrays.fill(m, 2);

        for (int r = 1; r <= R; r++) {
            String row = reader.readLine();
            for (int c = 1; c <= C; c++)
                map[r][c] = Character.getNumericValue(row.charAt(c - 1));
        }
    }

    private int search() {
        Queue<Point> points = new LinkedList<>(Collections.singleton(new Point(1, 1, 1, false)));
        while (!points.isEmpty()) {
            Point point = points.poll();
            if (point.row == R && point.col == C) return point.count;
            for (int move = 0; move < 4; move++) {
                int row = point.row + moveR[move];
                int col = point.col + moveC[move];
                if (map[row][col] == 0) {
                    if (!point.broke && !visited[row][col][0]) {
                        visited[row][col][0] = true;
                        points.offer(new Point(row, col, point.count + 1, false));
                    } else if (point.broke && !visited[row][col][1]) {
                        visited[row][col][1] = true;
                        points.offer(new Point(row, col, point.count + 1, true));
                    }
                } else if (map[row][col] == 1) {
                    if (!point.broke && !visited[row][col][1]) {
                        visited[row][col][1] = true;
                        points.offer(new Point(row, col, point.count + 1, true));
                    }
                }
            }
        }
        return -1;
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

    int row, col, count;
    boolean broke;

    public Point(int row, int col, int count, boolean broke) {
        this.row = row;
        this.col = col;
        this.count = count;
        this.broke = broke;
    }
}