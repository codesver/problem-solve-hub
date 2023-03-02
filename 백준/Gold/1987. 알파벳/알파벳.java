import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private char[][] board;
    private int max = 0;

    private final boolean[] alphabets = new boolean[26];
    private final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve() throws IOException {
        init();
        search(1, 1, 1);
        result.append(max);
    }

    private void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(tokenizer.nextToken());
        int col = Integer.parseInt(tokenizer.nextToken());
        board = new char[row + 2][col + 2];
        for (int r = 1; r <= row; r++) System.arraycopy(reader.readLine().toCharArray(), 0, board[r], 1, col);
        alphabets[board[1][1] - 65] = true;
    }

    private void search(int row, int col, int count) {
        max = Math.max(max, count);
        for (int[] move : moves) {
            if (board[row + move[0]][col + move[1]] != '\u0000' && !alphabets[board[row + move[0]][col + move[1]] - 65]) {
                alphabets[board[row + move[0]][col + move[1]] - 65] = true;
                search(row + move[0], col + move[1], count + 1);
                alphabets[board[row + move[0]][col + move[1]] - 65] = false;
            }
        }
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