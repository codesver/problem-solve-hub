import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private final int[][] initBoard = new int[9][9], board = new int[9][9];
    private final int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public void solve() throws IOException {
        init();
        search(0, 0);
        result.append(Arrays.stream(board).map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining()) + "\n").collect(Collectors.joining()));
    }

    private void init() throws IOException {
        for (int r = 0; r < 9; r++) {
            int[] row = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < 9; c++) initBoard[r][c] = board[r][c] = row[c];
        }
    }

    private boolean search(int row, int col) {
        if (initBoard[row][col] != 0) return (row + col == 16 || search(col + 1 == 9 ? row + 1 : row, (col + 1) % 9));
        else for (int n = 1; n <= 9; n++) {
            board[row][col] = n;
            if (validation(row, col) && (row + col == 16 || search(col + 1 == 9 ? row + 1 : row, (col + 1) % 9)))
                return true;
        }
        board[row][col] = 0;
        return false;
    }

    private boolean validation(int row, int col) {
        for (int rc = 0; rc < 9; rc++) {
            if (board[rc][col] == board[row][col] && rc != row) return false;
            if (board[row][rc] == board[row][col] && rc != col) return false;
        }
        int r = row / 3 * 3 + 1, c = col / 3 * 3 + 1;
        for (int m = 0; m < 9; m++)
            if (board[r + moves[m][0]][c + moves[m][1]] == board[row][col] && !(row == r + moves[m][0] && col == c + moves[m][1]))
                return false;
        return true;
    }

    private void finish() throws IOException {
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