import java.awt.*;
import java.io.*;
import java.util.Queue;
import java.util.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int row, col;
    private int[][] map;

    public void solve() throws IOException {
        input();
        searchPass();
        output();
    }

    private void searchPass() {
        for (int r = 1; r <= row; r++)
            for (int c = 1; c <= col; c++)
                if (map[r][c] == 0) countPass(r, c);
    }

    private void countPass(int r, int c) {
        Set<Point> walls = new HashSet<>();

        int count = 1;
        map[r][c] = -1;
        Queue<Point> zeros = new LinkedList<>(Collections.singleton(new Point(r, c)));
        while (!zeros.isEmpty()) {
            Point zero = zeros.poll();
            for (int m = 0; m < 4; m++) {
                int row = zero.x + moves[m][0];
                int col = zero.y + moves[m][1];
                if (map[row][col] > 0) walls.add(new Point(row, col));
                else if (map[row][col] == 0) {
                    count++;
                    map[row][col] = -1;
                    zeros.offer(new Point(row, col));
                }
            }
        }

        for (Point wall : walls) map[wall.x][wall.y] += count;
        walls.clear();
    }

    private void input() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        row = Integer.parseInt(tokenizer.nextToken());
        col = Integer.parseInt(tokenizer.nextToken());
        map = new int[row + 2][col + 2];
        Arrays.fill(map[0], 1);
        for (int r = 1; r <= row; r++)
            map[r] = ("1" + reader.readLine() + "1").chars().map(Character::getNumericValue).toArray();
        Arrays.fill(map[row + 1], 1);
    }

    private void output() {
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) result.append(map[r][c] < 0 ? 0 : map[r][c] % 10);
            result.append('\n');
        }
    }

    private void finish() throws IOException {
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