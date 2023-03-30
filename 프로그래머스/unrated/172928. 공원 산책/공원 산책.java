import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Character, Point> moves = new HashMap<>() {{
        put('N', new Point(-1, 0));
        put('E', new Point(0, 1));
        put('S', new Point(1, 0));
        put('W', new Point(0, -1));
    }};

    int ROW, COL;
    Point robot;
    boolean[][] map;

    public int[] solution(String[] park, String[] routes) {
        init(park);
        walk(routes);
        return new int[]{robot.x, robot.y};
    }

    private void init(String[] park) {
        ROW = park.length;
        COL = park[0].length();

        robot = new Point(0, 0);
        map = new boolean[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                char type = park[r].charAt(c);
                if (type == 'S') robot = new Point(r, c);
                map[r][c] = type != 'X';
            }
        }
    }

    private void walk(String[] routes) {
        loop:
        for (String route : routes) {
            Point direction = moves.get(route.charAt(0));
            int distance = Integer.parseInt(route.substring(2));

            int nextRow = robot.x + direction.x * distance;
            int nextCol = robot.y + direction.y * distance;

            if (robot.x != nextRow) {
                if (!(0 <= nextRow && nextRow < ROW)) continue;
                for (int r = Math.min(robot.x, nextRow); r <= Math.max(robot.x, nextRow); r++)
                    if (!map[r][robot.y]) continue loop;
            } else if (robot.y != nextCol) {
                if (!(0 <= nextCol && nextCol < COL)) continue;
                for (int c = Math.min(robot.y, nextCol); c <= Math.max(robot.y, nextCol); c++)
                    if (!map[robot.x][c]) continue loop;
            }
            robot.x = nextRow;
            robot.y = nextCol;
        }
    }
}
