import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        Map<Integer, Gear> gears = new HashMap<>();
        for (int gno = 1; gno <= 4; gno++) {
            int[] state = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            Gear gear = new Gear(state);
            gears.put(gno, gear);
        }

        for (int gno = 1; gno <= 4; gno++) {
            Gear gear = gears.get(gno);
            gear.addGear(Direction.LEFT, gears.get(gno - 1));
            gear.addGear(Direction.RIGHT, gears.get(gno + 1));
        }

        StringTokenizer tokenizer;
        int rnum = Integer.parseInt(reader.readLine());
        while (rnum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            Gear gear = gears.get(Integer.parseInt(tokenizer.nextToken()));
            gear.rotate(Integer.parseInt(tokenizer.nextToken()) == 1 ? Rotation.CLOCKWISE : Rotation.COUNTER_CLOCKWISE);
        }

        int score = IntStream.rangeClosed(1, 4)
                .map(gno -> (int) (gears.get(gno).getTopState() * Math.pow(2, gno - 1))).sum();
        result.append(score);
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

class Gear {

    private int top = 0;
    private Gear left, right;

    private final int[] state;

    public Gear(int[] state) {
        this.state = state;
    }

    public void rotate(Rotation rotation) {
        if (left != null && isStickTogether(Direction.LEFT)) left.rotate(rotation.opposite(), Direction.LEFT);
        if (right != null && isStickTogether(Direction.RIGHT)) right.rotate(rotation.opposite(), Direction.RIGHT);
        top = (top + (rotation == Rotation.CLOCKWISE ? 7 : 1)) % 8;
    }

    public void rotate(Rotation rotation, Direction direction) {
        if (direction == Direction.LEFT && left != null && isStickTogether(direction))
            left.rotate(rotation.opposite(), direction);
        if (direction == Direction.RIGHT && right != null && isStickTogether(direction))
            right.rotate(rotation.opposite(), direction);
        top = (top + (rotation == Rotation.CLOCKWISE ? 7 : 1)) % 8;
    }

    private boolean isStickTogether(Direction direction) {
        return getState(direction) != (direction == Direction.LEFT ? left : right).getState(direction.opposite());
    }

    private int getState(Direction direction) {
        if (direction == Direction.LEFT) return state[(top + 6) % 8];
        if (direction == Direction.RIGHT) return state[(top + 2) % 8];
        throw new RuntimeException("Should not reach here");
    }

    public void addGear(Direction direction, Gear gear) {
        if (direction == Direction.LEFT) left = gear;
        else if (direction == Direction.RIGHT) right = gear;
    }

    public int getTopState() {
        return state[top];
    }
}

enum Rotation {
    CLOCKWISE, COUNTER_CLOCKWISE;

    public Rotation opposite() {
        return this == CLOCKWISE ? COUNTER_CLOCKWISE : CLOCKWISE;
    }
}

enum Direction {
    LEFT, RIGHT;

    public Direction opposite() {
        return this == LEFT ? RIGHT : LEFT;
    }
}
