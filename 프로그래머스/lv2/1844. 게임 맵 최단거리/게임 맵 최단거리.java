import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[][] maps) {
        int[][] board = IntStream.range(0, maps.length + 2).mapToObj(r -> {
            int[] row = new int[maps[0].length + 2];
            if (r != 0 && r != maps.length + 1) System.arraycopy(maps[r - 1], 0, row, 1, maps[r - 1].length);
            return row;
        }).toArray(int[][]::new);
        board[1][1] = 0;
        Queue<Point> points = new LinkedList<>(Collections.singleton(new Point(1, 1, 1)));
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        while (!points.isEmpty()) {
            Point point = points.poll();
            if (point.row == maps.length && point.col == maps[0].length) return point.count;
            for (int i = 0; i < 4; i++) {
                if (board[point.row + row[i]][point.col + col[i]] != 0) {
                    board[point.row + row[i]][point.col + col[i]] = 0;
                    points.offer(new Point(point.row + row[i], point.col + col[i], point.count + 1));
                }
            }
        }
        return -1;
    }
}

class Point {

    int row, col, count;

    public Point(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}