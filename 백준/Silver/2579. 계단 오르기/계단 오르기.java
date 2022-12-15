import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int stairNum = Integer.parseInt(reader.readLine());
        int[] scores = new int[301];
        int[] sum = new int[301];
        for (int stair = 1; stair <= stairNum; stair++) scores[stair] = Integer.parseInt(reader.readLine());

        sum[1] = scores[1];
        sum[2] = scores[1] + scores[2];
        sum[3] = Math.max(scores[1] + scores[3], scores[2] + scores[3]);

        for (int stair = 4; stair <= stairNum; stair++)
            sum[stair] = Math.max(sum[stair - 3] + scores[stair - 1], sum[stair - 2]) + scores[stair];

        result.append(sum[stairNum]);
    }

    static class Exploration {
        int row, col, moveCount;

        public Exploration(int row, int col, int moveCount) {
            this.row = row;
            this.col = col;
            this.moveCount = moveCount;
        }
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