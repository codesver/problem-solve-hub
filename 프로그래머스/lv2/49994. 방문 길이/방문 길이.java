import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    private Point point = new Point(5, 5);
    private final boolean[][][][] visited = new boolean[11][11][11][11];
    private final Map<String, int[]> moves = new HashMap<>() {{
        put("U", new int[]{-1, 0});
        put("R", new int[]{0, 1});
        put("D", new int[]{1, 0});
        put("L", new int[]{0, -1});
    }};

    public int solution(String dirs) {
        return (int) Arrays.stream(dirs.split("")).map(moves::get).map(this::nextPoint).filter(this::inRange).filter(this::hasPassed).count();
    }

    private Point nextPoint(int[] move) {
        return new Point(point.x + move[0], point.y + move[1]);
    }

    private boolean inRange(Point point) {
        return 0 <= point.x && point.x < 11 && 0 <= point.y && point.y < 11;
    }

    private boolean hasPassed(Point nextPoint) {
        boolean passed = false;
        if (!visited[point.x][point.y][nextPoint.x][nextPoint.y])
            passed = visited[point.x][point.y][nextPoint.x][nextPoint.y] = visited[nextPoint.x][nextPoint.y][point.x][point.y] = true;
        point = nextPoint;
        return passed;
    }
}