import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int R = Integer.parseInt(tokenizer.nextToken());

        Board board = new Board(N, M);

        for (int row = 0; row < N; row++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int col = 0; col < M; col++) {
                board.addDomino(row, col, Integer.parseInt(tokenizer.nextToken()));
            }
        }

        while (R-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int row = Integer.parseInt(tokenizer.nextToken()) - 1;
            int col = Integer.parseInt(tokenizer.nextToken()) - 1;
            char dir = tokenizer.nextToken().charAt(0);
            board.attack(row, col, dir);
            tokenizer = new StringTokenizer(reader.readLine());
            row = Integer.parseInt(tokenizer.nextToken()) - 1;
            col = Integer.parseInt(tokenizer.nextToken()) - 1;
            board.defense(row, col);
        }

        result.append(board.getAttackScore()).append('\n');
        result.append(board);
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

class Board {

    private final Domino[][] dominoes;
    private int attackScore = 0;

    public Board(int row, int col) {
        dominoes = new Domino[row][col];
    }

    public void addDomino(int row, int col, int height) {
        dominoes[row][col] = new Domino(height);
    }

    public void attack(int row, int col, char dir) {
        Domino domino = dominoes[row][col];
        if (domino.isStanding()) {
            Direction direction = Direction.create(dir);
            int limitR = row + direction.row() * domino.getHeight();
            int limitC = col + direction.col() * domino.getHeight();
            for (int r = row, c = col;
                 r * direction.row() < limitR * direction.row() || c * direction.col() < limitC * direction.col();
                 r += direction.row(), c += direction.col()) {
                try {
                    domino = dominoes[r][c];
                    if (domino.isStanding()) {
                        attackScore++;
                        domino.knock();
                        limitR = direction.row() >= 0 ? Math.max(limitR, r + direction.row() * domino.getHeight()) :
                                Math.min(limitR, r + direction.row() * domino.getHeight());
                        limitC = direction.col() >= 0 ? Math.max(limitC, c + direction.col() * domino.getHeight()) :
                                Math.min(limitC, direction.col() * domino.getHeight());
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }
    }

    public void defense(int row, int col) {
        dominoes[row][col].stand();
    }

    public int getAttackScore() {
        return attackScore;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Domino[] dominoes : dominoes) {
            for (Domino domino : dominoes)
                builder.append(domino.isStanding() ? 'S' : 'F').append(' ');
            builder.append('\n');
        }
        return builder.toString();
    }
}

class Domino {

    private final int height;
    private boolean standing = true;

    public Domino(int height) {
        this.height = height;
    }

    public void knock() {
        standing = false;
    }

    public void stand() {
        standing = true;
    }

    public int getHeight() {
        return height;
    }

    public boolean isStanding() {
        return standing;
    }
}

enum Direction {
    NORTH('N', -1, 0),
    EAST('E', 0, 1),
    SOUTH('S', 1, 0),
    WEST('W', 0, -1);

    private final char dir;
    private final int row, col;

    Direction(char dir, int row, int col) {
        this.dir = dir;
        this.row = row;
        this.col = col;
    }

    public static Direction create(char dir) {
        for (Direction direction : values())
            if (direction.dir == dir) return direction;
        throw new RuntimeException("Wrong direction type");
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }
}