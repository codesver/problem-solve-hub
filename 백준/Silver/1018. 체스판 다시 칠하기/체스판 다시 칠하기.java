import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        boolean[][] board = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            String[] line = reader.readLine().split("");
            for (int m = 0; m < M; m++)
                board[n][m] = line[m].equals("W");
        }

        int min = Integer.MAX_VALUE;
        for (int n = 0; n < N - 7; n++) 
            for (int m = 0; m < M - 7; m++)
                min = Math.min(min, countChanges(board, n, m));

        result.append(min);
    }

    private static int countChanges(boolean[][] board, int n, int m) {
        int countChangesStartingWithWhite = 0;
        int countChangesStartingWithBlack = 0;

        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                boolean currentType = board[i][j];
                boolean startingWithWhite = ((i - n) + (j - m)) % 2 == 0;

                countChangesStartingWithWhite += currentType == !startingWithWhite ? 1 : 0;
                countChangesStartingWithBlack += currentType == startingWithWhite ? 1 : 0;
            }
        }

        return Math.min(countChangesStartingWithWhite, countChangesStartingWithBlack);
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