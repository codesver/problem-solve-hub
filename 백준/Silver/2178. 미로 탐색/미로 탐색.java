import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][] maze;
    private static final Queue<Exploration> explorations = new LinkedList<>();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(tokenizer.nextToken());
        int col = Integer.parseInt(tokenizer.nextToken());
        maze = new int[row + 2][col + 2];
        for (int r = 1; r < row + 1; r++)
            maze[r] = ("0" + reader.readLine() + "0").chars().map(Character::getNumericValue).toArray();
        exploreTo(row, col);
    }

    private static void exploreTo(int targetR, int targetC) {
        explorations.add(new Exploration(1, 1, 1));
        while (!explorations.isEmpty()) {
            Exploration exploration = explorations.poll();
            if (exploration.row == targetR && exploration.col == targetC) {
                result.append(exploration.moveCount);
                break;
            }
            if (maze[exploration.row][exploration.col + 1] == 1)
                explore(exploration.row, exploration.col + 1, exploration.moveCount + 1);
            if (maze[exploration.row + 1][exploration.col] == 1)
                explore(exploration.row + 1, exploration.col, exploration.moveCount + 1);
            if (maze[exploration.row - 1][exploration.col] == 1)
                explore(exploration.row - 1, exploration.col, exploration.moveCount + 1);
            if (maze[exploration.row][exploration.col - 1] == 1)
                explore(exploration.row, exploration.col - 1, exploration.moveCount + 1);
        }
    }

    private static void explore(int nextR, int nextC, int moveCount) {
        explorations.add(new Exploration(nextR, nextC, moveCount));
        maze[nextR][nextC] = 0;
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