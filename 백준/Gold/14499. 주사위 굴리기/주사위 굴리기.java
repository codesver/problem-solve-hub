import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        DiceMap diceMap = new DiceMap(N, M, x, y);

        for (int row = 0; row < N; row++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int col = 0; col < M; col++)
                diceMap.setMapNumber(row, col, Integer.parseInt(tokenizer.nextToken()));
        }

        tokenizer = new StringTokenizer(reader.readLine());
        while (K-- > 0) {
            int dir = Integer.parseInt(tokenizer.nextToken());
            Direction direction = switch (dir) {
                case 1 -> Direction.EAST;
                case 2 -> Direction.WEST;
                case 3 -> Direction.NORTH;
                case 4 -> Direction.SOUTH;
                default -> throw new IllegalArgumentException("Not available direction");
            };
            try {
                result.append(diceMap.rollDice(direction)).append("\n");
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
    }

    public void submit() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.submit();
    }
}

class DiceMap {

    private final Dice dice;
    private final int[][] map;

    public DiceMap(int rowSize, int colSize, int diceRowLoc, int diceColLoc) {
        map = new int[rowSize][colSize];
        dice = new Dice(diceRowLoc, diceColLoc);
    }

    public void setMapNumber(int row, int col, int num) {
        map[row][col] = num;
    }

    public int rollDice(Direction direction) {
        return dice.roll(direction, map);
    }
}

class Dice {

    private int row, col;
    private final Eye top, bottom;
    private final Map<Direction, List<Eye>> rolls = new HashMap<>();

    public Dice(int row, int col) {
        this.row = row;
        this.col = col;
        top = new Eye();
        bottom = new Eye();
        Eye front = new Eye(), back = new Eye(), right = new Eye(), left = new Eye();
        rolls.put(Direction.NORTH, List.of(back, top, front, bottom));
        rolls.put(Direction.EAST, List.of(right, top, left, bottom));
        rolls.put(Direction.SOUTH, List.of(front, top, back, bottom));
        rolls.put(Direction.WEST, List.of(left, top, right, bottom));
    }

    public int roll(Direction direction, int[][] map) {
        int num = map[row + direction.getRow()][col + direction.getCol()];
        row += direction.getRow();
        col += direction.getCol();
        rollEyes(rolls.get(direction));
        if (num == 0) map[row][col] = bottom.getNum();
        else {
            bottom.setNum(map[row][col]);
            map[row][col] = 0;
        }
        return top.getNum();
    }

    private void rollEyes(List<Eye> eyes) {
        int temp = eyes.get(0).getNum();
        eyes.get(0).setNum(eyes.get(1).getNum());
        eyes.get(1).setNum(eyes.get(2).getNum());
        eyes.get(2).setNum(eyes.get(3).getNum());
        eyes.get(3).setNum(temp);
    }
}

class Eye {

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

enum Direction {
    NORTH(-1, 0), EAST(0, 1), SOUTH(1, 0), WEST(0, -1);

    private final int row, col;

    Direction(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}