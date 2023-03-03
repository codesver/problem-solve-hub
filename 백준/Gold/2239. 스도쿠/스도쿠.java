import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private final List<Point> blanks = new ArrayList<>();
    private final int[][] board = new int[9][9];
    private final int[] rowNums = new int[9], colNums = new int[9];
    private final int[][] blockNums = new int[3][3];

    public void solve() throws IOException {
        init();
        search(0);
        result.append(Arrays.stream(board).map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining()) + "\n").collect(Collectors.joining()));
    }

    private void init() throws IOException {
        for (int r = 0; r < 9; r++) {
            int[] row = Arrays.stream(reader.readLine().split(""))
                    .mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < 9; c++) {
                if ((board[r][c] = row[c]) != 0) {
                    int visitBit = 1 << board[r][c] - 1;
                    rowNums[r] |= visitBit;
                    colNums[c] |= visitBit;
                    blockNums[r / 3][c / 3] |= visitBit;
                } else blanks.add(new Point(r, c));
            }
        }
    }

    private boolean search(int index) {
        if (index == blanks.size()) return true;
        int row = blanks.get(index).x, col = blanks.get(index).y;
        int visit = rowNums[row] | colNums[col] | blockNums[row / 3][col / 3];

        for (int num = 1; num <= 9; num++) {
            int bit = 1 << (num - 1);
            if ((visit & bit) != 0) continue;
            board[row][col] = num;
            rowNums[row] |= bit;
            colNums[col] |= bit;
            blockNums[row / 3][col / 3] |= bit;
            if (search(index + 1)) return true;
            board[row][col] = 0;
            rowNums[row] &= ~bit;
            colNums[col] &= ~bit;
            blockNums[row / 3][col / 3] &= ~bit;
        }
        return false;
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