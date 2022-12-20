import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][] paper;
    private static boolean[][] visited;
    private static int max = Integer.MIN_VALUE;

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(tokenizer.nextToken());
        int col = Integer.parseInt(tokenizer.nextToken());

        initialize(row, col);
        search(row, col);
        result.append(max);
    }

    private static void initialize(int row, int col) throws IOException {
        StringTokenizer tokenizer;
        paper = new int[row + 2][col + 2];
        visited = new boolean[row + 2][col + 2];
        for (int r = 1; r <= row; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 1; c <= col; c++) paper[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void search(int row, int col) {
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                visited[r][c] = true;
                dfs(r, c, 1, paper[r][c]);
                visited[r][c] = false;
                max = Math.max(max, specialSearch(r, c));
            }
        }
    }

    private static void dfs(int row, int col, int depth, int sum) {
        if (depth == 4) max = Math.max(max, sum);
        else {
            deeper(row - 1, col, depth + 1, sum);
            deeper(row, col + 1, depth + 1, sum);
            deeper(row + 1, col, depth + 1, sum);
            deeper(row, col - 1, depth + 1, sum);
        }
    }

    private static void deeper(int row, int col, int depth, int sum) {
        if (!visited[row][col] && paper[row][col] != 0) {
            visited[row][col] = true;
            dfs(row, col, depth, sum + paper[row][col]);
            visited[row][col] = false;
        }
    }

    private static int specialSearch(int row, int col) {
        int up = paper[row - 1][col];
        int right = paper[row][col + 1];
        int down = paper[row + 1][col];
        int left = paper[row][col - 1];
        return paper[row][col] + up + right + down + left - Math.min(Math.min(up, down), Math.min(right, left));
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