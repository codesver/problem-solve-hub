import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int K = Integer.parseInt(reader.readLine());

        Dummy dummy = new Dummy(N);

        StringTokenizer tokenizer;
        while (K-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            dummy.addApple(Integer.parseInt(tokenizer.nextToken()) - 1, Integer.parseInt(tokenizer.nextToken()) - 1);
        }

        int turnNum = Integer.parseInt(reader.readLine());
        while (turnNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            dummy.addTurn(Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken().charAt(0));
        }

        result.append(dummy.playGame());
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

class Dummy {

    private final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int headRow, headCol, tailRow, tailCol;
    private final int[][] board;
    private final Queue<Turn> turns = new LinkedList<>();

    public Dummy(int boardSize) {
        board = new int[boardSize][boardSize];
        board[0][0] = 2;
    }

    public void addApple(int row, int col) {
        board[row][col] = -1;
    }

    public void addTurn(int time, char dir) {
        turns.offer(new Turn(time, dir));
    }

    public int playGame() {
        int time = 0;
        while (true) {
            time++;
            try {
                move();
            } catch (ArrayIndexOutOfBoundsException e) {
                return time;
            }

            if (!turns.isEmpty() && turns.peek().time == time) {
                Turn turn = turns.poll();
                board[headRow][headCol] = ((board[headRow][headCol] - 1)
                        + (turn.dir == 'L' ? 3 : 1)) % 4 + 1;
            }
        }
    }

    private void move() {
        int nextRow = headRow + moves[board[headRow][headCol] - 1][0];
        int nextCol = headCol + moves[board[headRow][headCol] - 1][1];

        if (board[nextRow][nextCol] > 0) throw new ArrayIndexOutOfBoundsException();

        boolean grow = board[nextRow][nextCol] == -1;
        board[nextRow][nextCol] = board[headRow][headCol];
        headRow = nextRow;
        headCol = nextCol;

        if (!grow) {
            nextRow = tailRow + moves[board[tailRow][tailCol] - 1][0];
            nextCol = tailCol + moves[board[tailRow][tailCol] - 1][1];
            board[tailRow][tailCol] = 0;
            tailRow = nextRow;
            tailCol = nextCol;
        }
    }
}

class Turn {
    int time;
    char dir;

    public Turn(int time, char dir) {
        this.time = time;
        this.dir = dir;
    }
}