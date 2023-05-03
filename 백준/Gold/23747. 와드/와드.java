import java.awt.*;
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int ROW = Integer.parseInt(tokenizer.nextToken());
        int COL = Integer.parseInt(tokenizer.nextToken());
        char[][] map = new char[ROW][COL];
        for (int row = 0; row < ROW; row++) map[row] = reader.readLine().toCharArray();

        Isekai isekai = new Isekai(map);

        tokenizer = new StringTokenizer(reader.readLine());
        int dropRow = Integer.parseInt(tokenizer.nextToken()) - 1;
        int dropCol = Integer.parseInt(tokenizer.nextToken()) - 1;
        isekai.drop(dropRow, dropCol);

        reader.readLine().chars().forEach(isekai::move);
        isekai.extendVisual();

        result.append(isekai);
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

class Isekai {

    private int row, col;
    private final char[][] map;

    public Isekai(char[][] map) {
        this.map = map;
    }

    public void drop(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void move(int movement) {
        if (movement == 'U') row--;
        else if (movement == 'R') col++;
        else if (movement == 'D') row++;
        else if (movement == 'L') col--;
        else if (movement == 'W') plantWard();
    }

    private void plantWard() {
        if (map[row][col] == '.') return;
        char type = map[row][col];
        map[row][col] = '.';
        Queue<Point> points = new LinkedList<>(Collections.singleton(new Point(row, col)));
        while (!points.isEmpty()) {
            Point point = points.poll();
            for (Direction direction : Direction.values()) {
                try {
                    if (map[point.x + direction.row][point.y + direction.col] == type) {
                        map[point.x + direction.row][point.y + direction.col] = '.';
                        points.offer(new Point(point.x + direction.row, point.y + direction.col));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
    }

    public void extendVisual() {
        map[row][col] = '.';
        for (Direction direction : Direction.values()) {
            try {
                map[row + direction.row][col + direction.col] = '.';
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (char[] m : map) {
            for (char c : m) builder.append(c == '.' ? c : '#');
            builder.append('\n');
        }
        return builder.toString();
    }
}

enum Direction {
    NORTH(-1, 0), EAST(0, 1), SOUTH(1, 0), WEST(0, -1);

    final int row, col;

    Direction(int row, int col) {
        this.row = row;
        this.col = col;
    }
}