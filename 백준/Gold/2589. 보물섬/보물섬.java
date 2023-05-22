import java.io.*;
import java.util.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Point {
        int row, col, distance;

        public Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(tokenizer.nextToken());
        int col = Integer.parseInt(tokenizer.nextToken());
        char[][] map = new char[row][col];
        for (int r = 0; r < row; r++) {
            String rowInfo = reader.readLine();
            for (int c = 0; c < col; c++) map[r][c] = rowInfo.charAt(c);
        }
        int maxDistance = 0;
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++)
                if (map[r][c] == 'L') maxDistance = Math.max(maxDistance, searchLand(map, r, c));
        result.append(maxDistance);
    }

    private int searchLand(char[][] map, int row, int col) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[row][col] = true;
        Queue<Point> points = new LinkedList<>(Collections.singleton(new Point(row, col, 0)));

        int maxDistance = 0;
        while (!points.isEmpty()) {
            Point point = points.poll();
            maxDistance = Math.max(maxDistance, point.distance);
            for(int m = 0; m < 4; m++) {
                try {
                    int nextRow = point.row + moves[m][0];
                    int nextCol = point.col + moves[m][1];
                    if (map[nextRow][nextCol] == 'L' && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        points.offer(new Point(nextRow, nextCol, point.distance + 1));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
        return maxDistance;
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