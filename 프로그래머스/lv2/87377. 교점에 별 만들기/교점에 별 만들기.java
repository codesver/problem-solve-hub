import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Point {

    long x, y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE, minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point point = intersect(line[i], line[j]);
                if (point != null) {
                    points.add(point);
                    maxX = Math.max(maxX, point.x);
                    maxY = Math.max(maxY, point.y);
                    minX = Math.min(minX, point.x);
                    minY = Math.min(minY, point.y);
                }
            }
        }

        char[][] map = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        for (char[] m : map) Arrays.fill(m, '.');
        for (Point point : points) map[(int) (maxY - point.y)][(int) (point.x - minX)] = '*';
        return Arrays.stream(map).map(String::new).toArray(String[]::new);
    }

    private Point intersect(int[]... infos) {
        double criteria = (double) ((long) infos[0][0] * (long) infos[1][1] - (long) infos[1][0] * (long) infos[0][1]);
        if (criteria == 0) return null;
        double x = ((long) infos[0][1] * (long) infos[1][2] - (long) infos[1][1] * (long) infos[0][2]) / criteria;
        double y = ((long) infos[0][2] * (long) infos[1][0] - (long) infos[0][0] * (long) infos[1][2]) / criteria;
        return x == (long) x && y == (long) y ? new Point((long) x, (long) y) : null;
    }
}