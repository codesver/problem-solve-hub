import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        Machine machine = new Machine();

        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0)
            machine.addGear(Arrays.stream(reader.readLine().split(""))
                    .mapToInt(Integer::parseInt).toArray());

        StringTokenizer tokenizer;
        int K = Integer.parseInt(reader.readLine());
        while (K-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int gno = Integer.parseInt(tokenizer.nextToken()) - 1;
            int rotate = Integer.parseInt(tokenizer.nextToken());
            machine.rotateGear(gno, rotate == 1 ? Rotation.CLOCKWISE : Rotation.COUNTER_CLOCKWISE);
        }

        result.append(machine.sumGearsTop());
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

class Machine {

    private final List<Gear> gears = new ArrayList<>();

    public void addGear(int[] sawtooth) {
        gears.add(new Gear(sawtooth));
    }

    public void rotateGear(int gno, Rotation rotation) {
        Gear gear = gears.get(gno);
        if (gno >= 1 && gear.moveTogether(gears.get(gno - 1), Direction.LEFT))
            rotateGear(gno - 1, rotation.counter(), Direction.LEFT);
        if (gno + 1 < gears.size() && gear.moveTogether(gears.get(gno + 1), Direction.RIGHT))
            rotateGear(gno + 1, rotation.counter(), Direction.RIGHT);
        gear.rotate(rotation);
    }

    public void rotateGear(int gno, Rotation rotation, Direction direction) {
        Gear gear = gears.get(gno);
        if (direction == Direction.LEFT && gno >= 1 && gear.moveTogether(gears.get(gno - 1), direction))
            rotateGear(gno - 1, rotation.counter(), direction);
        else if (direction == Direction.RIGHT && gno + 1 < gears.size() && gear.moveTogether(gears.get(gno + 1), direction))
            rotateGear(gno + 1, rotation.counter(), direction);
        gear.rotate(rotation);
    }

    public int sumGearsTop() {
        return gears.stream().mapToInt(Gear::getTop).sum();
    }
}

class Gear {

    private int top = 0;
    private final int[] sawtooth;

    public Gear(int[] sawtooth) {
        this.sawtooth = sawtooth;
    }

    public boolean moveTogether(Gear gear, Direction direction) {
        return direction == Direction.LEFT && getLeft() != gear.getRight() ||
                direction == Direction.RIGHT && getRight() != gear.getLeft();
    }

    public void rotate(Rotation rotation) {
        if (rotation == Rotation.CLOCKWISE) top = (top + 7) % 8;
        else if (rotation == Rotation.COUNTER_CLOCKWISE) top = (top + 1) % 8;
    }

    public int getTop() {
        return sawtooth[top];
    }

    private int getLeft() {
        return sawtooth[(top + 6) % 8];
    }

    private int getRight() {
        return sawtooth[(top + 2) % 8];
    }
}

enum Rotation {
    CLOCKWISE(1), COUNTER_CLOCKWISE(-1);

    private final int rotate;

    Rotation(int rotate) {
        this.rotate = rotate;
    }

    public Rotation counter() {
        return rotate == 1 ? COUNTER_CLOCKWISE : CLOCKWISE;
    }
}

enum Direction {LEFT, RIGHT}