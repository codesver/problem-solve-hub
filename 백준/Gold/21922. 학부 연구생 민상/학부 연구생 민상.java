import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(tokenizer.nextToken());
        int col = Integer.parseInt(tokenizer.nextToken());

        Laboratory laboratory = new Laboratory(row, col);

        for (int r = 0; r < row; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < col; c++)
                laboratory.addThing(r, c, Integer.parseInt(tokenizer.nextToken()));
        }

        laboratory.turnOnAirConditioners();

        result.append(laboratory.availableSeats());
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

class Laboratory {

    private final Thing[][] things;
    private final boolean[][][] windBlew;
    private final boolean[][] availableSeat;

    public Laboratory(int row, int col) {
        things = new Thing[row][col];
        windBlew = new boolean[row][col][4];
        availableSeat = new boolean[row][col];
    }

    public void addThing(int row, int col, int type) {
        things[row][col] = Thing.values()[type == 9 ? 5 : type];
    }

    public void turnOnAirConditioners() {
        for (int row = 0; row < things.length; row++)
            for (int col = 0; col < things[row].length; col++)
                if (things[row][col].isAirConditioner())
                    for (Direction direction : Direction.values())
                        windBlow(row, col, direction);
    }

    private void windBlow(int row, int col, Direction direction) {
        availableSeat[row][col] = windBlew[row][col][direction.dir] = true;
        direction = things[row][col].convert(direction);
        try {
            if (!windBlew[row + direction.row][col + direction.col][direction.dir])
                windBlow(row + direction.row, col + direction.col, direction);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }

    public int availableSeats() {
        int count = 0;
        for (boolean[] seats : availableSeat)
            for (boolean seat : seats) if (seat) count++;
        return count;
    }
}

enum Thing {
    NULL, ONE, TWO, THREE, FOUR, AIR_CONDITIONER;

    public boolean isAirConditioner() {
        return this == AIR_CONDITIONER;
    }

    public Direction convert(Direction direction) {
        if (this == ONE) return direction.isVertical() ? direction : direction.reverse();
        else if (this == TWO) return direction.isVertical() ? direction.reverse() : direction;
        else if (this == THREE) return direction.isVertical() ? direction.postDirection() : direction.preDirection();
        else if (this == FOUR) return direction.isVertical() ? direction.preDirection() : direction.postDirection();
        else return direction;
    }
}

enum Direction {
    NORTH(-1, 0, 0),
    EAST(0, 1, 1),
    SOUTH(1, 0, 2),
    WEST(0, -1, 3);

    final int row, col, dir;

    Direction(int row, int col, int dir) {
        this.row = row;
        this.col = col;
        this.dir = dir;
    }

    public boolean isVertical() {
        return this == NORTH || this == SOUTH;
    }

    public Direction reverse() {
        return Direction.values()[(this.dir + 2) % 4];
    }

    public Direction preDirection() {
        return Direction.values()[(this.dir + 3) % 4];
    }

    public Direction postDirection() {
        return Direction.values()[(this.dir + 1) % 4];
    }
}