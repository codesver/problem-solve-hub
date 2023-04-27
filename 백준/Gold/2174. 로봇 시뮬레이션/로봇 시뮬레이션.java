import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        CommandCenter commandCenter = new CommandCenter(A, B);

        while (N-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String direction = tokenizer.nextToken();
            commandCenter.deployRobot(x, y, direction);
        }

        try {
            while (M-- > 0) {
                tokenizer = new StringTokenizer(reader.readLine());
                int rno = Integer.parseInt(tokenizer.nextToken());
                String command = tokenizer.nextToken();
                int repeat = Integer.parseInt(tokenizer.nextToken());
                commandCenter.commandRobot(rno, command, repeat);
            }
            result.append("OK");
        } catch (RobotException exception) {
            result.append(exception.getMessage());
        }
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

class CommandCenter {

    private final List<Robot> robots = new ArrayList<>();
    private final Robot[][] robotMap;

    public CommandCenter(int maxX, int maxY) {
        robotMap = new Robot[maxX][maxY];
    }

    public void deployRobot(int x, int y, String direction) {
        Robot robot = new Robot(robots.size() + 1, x, y, direction);
        robots.add(robot);
        robotMap[x - 1][y - 1] = robot;
    }

    public void commandRobot(int rno, String command, int repeat) {
        Robot robot = robots.get(rno - 1);
        while (repeat-- > 0) robot.readCommand(command, robotMap);
    }
}

class Robot {

    private final int rno;
    private int x, y;
    private Direction direction;

    public Robot(int rno, int x, int y, String direction) {
        this.rno = rno;
        this.x = x;
        this.y = y;
        this.direction = Direction.createDirection(direction);
    }

    public void readCommand(String command, Robot[][] robotMap) {
        if (command.equals("L")) direction = direction.preDirection();
        else if (command.equals("R")) direction = direction.postDirection();
        else if (command.equals("F")) moveForward(robotMap);
    }

    private void moveForward(Robot[][] robotMap) {
        int nextX = x + direction.getX();
        int nextY = y + direction.getY();
        try {
            if (robotMap[nextX - 1][nextY - 1] != null)
                throw new RobotException(rno, robotMap[nextX - 1][nextY - 1].rno);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RobotException(rno);
        }
        robotMap[x - 1][y - 1] = null;
        robotMap[(x = nextX) - 1][(y = nextY) - 1] = this;
    }
}

enum Direction {
    NORTH(0, "N", 0, 1),
    EAST(1, "E", 1, 0),
    SOUTH(2, "S", 0, -1),
    WEST(3, "W", -1, 0);

    private final int index;
    private final String direction;
    private final int x, y;

    Direction(int index, String direction, int x, int y) {
        this.index = index;
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public static Direction createDirection(String dir) {
        for (Direction direction : values())
            if (direction.direction.equals(dir)) return direction;
        throw new RuntimeException("Wrong direction is given");
    }

    public Direction preDirection() {
        return values()[(this.index + values().length - 1) % values().length];
    }

    public Direction postDirection() {
        return values()[(this.index + 1) % values().length];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class RobotException extends RuntimeException {

    public RobotException(int rno) {
        super("Robot " + rno + " crashes into the wall");
    }

    public RobotException(int from, int to) {
        super("Robot " + from + " crashes into robot " + to);
    }
}