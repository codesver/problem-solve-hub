import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    final char[][] rooms = new char[7][7];

    public int[] solution(String[][] places) {
        return Arrays.stream(places).mapToInt(place -> {
            for (char[] room : rooms) Arrays.fill(room, 'X');
            for (int r = 1; r <= 5; r++)
                for (int c = 1; c <= 5; c++)
                    rooms[r][c] = place[r - 1].charAt(c - 1);
            for (int r = 1; r <= 5; r++)
                for (int c = 1; c <= 5; c++)
                    if (rooms[r][c] == 'P' && search(r, c)) return 0;
            return 1;
        }).toArray();
    }

    public boolean search(int r, int c) {
        rooms[r][c] = 'X';
        Queue<Point> points = new LinkedList<>(Collections.singleton(new Point(r, c, 0)));
        while (!points.isEmpty()) {
            Point point = points.poll();
            if (rooms[point.r][point.c] == 'P') return true;
            if (point.count == 2) continue;
            if (next(points, point.r - 1, point.c, point.count + 1)) return true;
            if (next(points, point.r + 1, point.c, point.count + 1)) return true;
            if (next(points, point.r, point.c - 1, point.count + 1)) return true;
            if (next(points, point.r, point.c + 1, point.count + 1)) return true;
        }
        return false;
    }

    public boolean next(Queue<Point> points, int r, int c, int count) {
        if (rooms[r][c] != 'X') {
            if (rooms[r][c] == 'P') return true;
            rooms[r][c] = 'X';
            points.add(new Point(r, c, count));
        }
        return false;
    }
}

class Point {

    int r, c;
    int count;

    public Point(int r, int c, int count) {
        this.r = r;
        this.c = c;
        this.count = count;
    }
}