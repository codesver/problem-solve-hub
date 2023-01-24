import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int N;
    private static int count = 0;
    private static int[] board;

    private static void solution() throws IOException {
        N = Integer.parseInt(reader.readLine());
        board = new int[N];

        for (int col = 0; col < N; col++) {
            board[0] = col;
            search(1);
        }

        result.append(count);
    }

    private static void search(int row) {
        if (row == N) count++;
        else for (int col = 0; col < N; col++) {
            if (valid(row, col)) {
                board[row] = col;
                search(row + 1);
            }
        }
    }

    private static boolean valid(int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r] == col) return false;
            if (Math.abs(r - row) == Math.abs(board[r] - col)) return false;
        }
        return true;
    }

    private static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}