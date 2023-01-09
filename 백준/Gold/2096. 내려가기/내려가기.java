import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int L = Integer.parseInt(reader.readLine());
        int[][] board = new int[L][3];
        int[][] max = new int[L][3];
        int[][] min = new int[L][3];
        for (int s = 0; s < L; s++)
            board[s] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        if (L == 1) result.append(max(board[0])).append(" ").append(min(board[0]));
        else {
            max[0] = board[0].clone();
            min[0] = board[0].clone();

            IntStream.range(1, L).forEach(stair -> {
                max[stair][0] = max(max[stair - 1][0], max[stair - 1][1]) + board[stair][0];
                max[stair][1] = max(max[stair - 1][0], max[stair - 1][1], max[stair - 1][2]) + board[stair][1];
                max[stair][2] = max(max[stair - 1][1], max[stair - 1][2]) + board[stair][2];

                min[stair][0] = min(min[stair - 1][0], min[stair - 1][1]) + board[stair][0];
                min[stair][1] = min(min[stair - 1][0], min[stair - 1][1], min[stair - 1][2]) + board[stair][1];
                min[stair][2] = min(min[stair - 1][1], min[stair - 1][2]) + board[stair][2];
            });

            result.append(max(max[L - 1])).append(" ").append(min(min[L - 1]));
        }
    }

    private static void update(int stair, int[][] dp) {
        
    }

    private static int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(max, num);
        return max;
    }

    private static int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) min = Math.min(min, num);
        return min;
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