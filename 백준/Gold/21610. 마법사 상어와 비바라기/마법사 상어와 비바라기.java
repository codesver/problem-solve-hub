import java.io.*;
import java.util.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        final int SIZE = Integer.parseInt(tokenizer.nextToken());
        int moveNum = Integer.parseInt(tokenizer.nextToken());

        Field field = new Field(SIZE);
        for (int row = 0; row < SIZE; row++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int col = 0; col < SIZE; col++) field.addBasket(row, col, Integer.parseInt(tokenizer.nextToken()));
        }

        field.createCloud(SIZE - 1, 0);
        field.createCloud(SIZE - 1, 1);
        field.createCloud(SIZE - 2, 0);
        field.createCloud(SIZE - 2, 1);

        while (moveNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int directionNo = Integer.parseInt(tokenizer.nextToken());
            int distance = Integer.parseInt(tokenizer.nextToken());
            field.command(directionNo, distance);
        }

        result.append(field.collectWater());
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

class Field {

    private final int SIZE;
    private final Basket[][] baskets;
    private final List<Cloud> clouds = new ArrayList<>();

    public Field(int size) {
        SIZE = size;
        baskets = new Basket[SIZE][SIZE];
    }

    public void command(int directionNo, int dis) {
        Queue<Basket> increasedBaskets = new PriorityQueue<>();

        Direction direction = Direction.getDirection(directionNo);
        for (Cloud cloud : clouds) {
            cloud.move(direction, dis, SIZE);
            increasedBaskets.offer(cloud.rain(baskets));
        }

        clouds.clear();

        for (Basket basket : increasedBaskets) basket.copyWater(baskets);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Basket basket = baskets[row][col];
                if (baskets[row][col].equals(increasedBaskets.peek())) increasedBaskets.poll();
                else if (basket.hasEnoughWater(2)) clouds.add(basket.createCloud());
            }
        }
    }

    public void createCloud(int row, int col) {
        clouds.add(new Cloud(row, col));
    }

    public void addBasket(int row, int col, int water) {
        baskets[row][col] = new Basket(row, col, water);
    }

    public int collectWater() {
        int amountOfWater = 0;
        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col++)
                amountOfWater += baskets[row][col].getWater();
        return amountOfWater;
    }
}

class Basket implements Comparable<Basket> {

    private final int ROW, COL;
    private int water;

    public Basket(int row, int col, int water) {
        this.ROW = row;
        this.COL = col;
        this.water = water;
    }

    public void copyWater(Basket[][] baskets) {
        for (int d = 2; d <= 8; d += 2) {
            Direction direction = Direction.getDirection(d);
            try {
                Basket basket = baskets[ROW + direction.row()][COL + direction.col()];
                if (basket.hasEnoughWater(1)) addWater(1);
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
        }
    }

    public void addWater(int water) {
        this.water += water;
    }

    public boolean hasEnoughWater(int water) {
        return this.water >= water;
    }

    public Cloud createCloud() {
        water -= 2;
        return new Cloud(ROW, COL);
    }

    public int getWater() {
        return water;
    }

    @Override
    public int compareTo(Basket b) {
        return ROW == b.ROW ? COL - b.COL : ROW - b.ROW;
    }
}

class Cloud {

    private int row, col;

    public Cloud(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void move(Direction direction, int distance, int limit) {
        row += direction.row() * distance;
        col += direction.col() * distance;
        if (row >= 0) row %= limit;
        else while (row < 0) row += limit;
        if (col >= 0) col %= limit;
        else while (col < 0) col += limit;
    }

    public Basket rain(Basket[][] baskets) {
        baskets[row][col].addWater(1);
        return baskets[row][col];
    }
}

enum Direction {
    W(0, -1), NW(-1, -1), N(-1, 0), NE(-1, 1),
    E(0, 1), SE(1, 1), S(1, 0), SW(1, -1);

    private final int row, col;

    Direction(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Direction getDirection(int direction) {
        return Direction.values()[direction - 1];
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }
}