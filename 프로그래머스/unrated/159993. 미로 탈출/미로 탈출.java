import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public Point start, lever, end;
    public int[][] mapToLever, mapToEnd;

    public int solution(String[] maps) {
        resolveMaps(maps);
        int searchLever = search(start, lever, mapToLever);
        if (searchLever == -1) return -1;
        int searchEnd = search(lever, end, mapToEnd);
        if (searchEnd == -1) return -1;
        return searchLever + searchEnd;
    }

    public void resolveMaps(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        mapToLever = new int[row + 2][col + 2];
        mapToEnd = new int[row + 2][col + 2];
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                char type = maps[r - 1].charAt(c - 1);
                if (type == 'S') start = new Point(r, c, 0);
                else if (type == 'L') lever = new Point(r, c, 0);
                else if (type == 'E') end = new Point(r, c, 0);
                mapToLever[r][c] = mapToEnd[r][c] = type;
            }
        }
    }

    public int search(Point from, Point target, int[][] map) {
        map[from.row][from.col] = 'X';
        Queue<Point> points = new LinkedList<>(Collections.singleton(from));
        while (!points.isEmpty()) {
            Point point = points.poll();
            if (point.row == target.row && point.col == target.col) return point.movement;
            move(points, map, point.row - 1, point.col, point.movement + 1);
            move(points, map, point.row + 1, point.col, point.movement + 1);
            move(points, map, point.row, point.col - 1, point.movement + 1);
            move(points, map, point.row, point.col + 1, point.movement + 1);
        }
        return -1;
    }

    public void move(Queue<Point> points, int[][] map, int row, int col, int movement) {
        if (map[row][col] != 'X' && map[row][col] != '\u0000') {
            map[row][col] = 'X';
            points.offer(new Point(row, col, movement));
        }
    }
}

class Point {

    int row, col, movement;

    public Point(int row, int col, int movement) {
        this.row = row;
        this.col = col;
        this.movement = movement;
    }
}