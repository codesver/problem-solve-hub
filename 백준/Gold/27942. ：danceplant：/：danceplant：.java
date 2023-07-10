import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[][] stage = new int[N][N];

        StringTokenizer tokenizer;
        for (int r = 0; r < N; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; c++) {
                stage[r][c] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        DancePlant dancePlant = new DancePlant(N, stage);

        StringBuilder history = new StringBuilder();
        while (true) {
            char direction = dancePlant.dance();
            if (direction == ' ') break;
            history.append(direction);
        }

        result.append(dancePlant.getEnergy()).append('\n').append(history);
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

class DancePlant {

    private int startRow, startCol, endRow, endCol;
    private final int[][] stage;
    private int energy;

    public DancePlant(int size, int[][] stage) {
        this.stage = stage;
        startRow = startCol = size / 2 - 1;
        endRow = endCol = size / 2;
    }

    public char dance() {
        int up = startRow == 0 ? 0 : IntStream.rangeClosed(startCol, endCol).map(c -> stage[startRow - 1][c]).sum();
        int down = endRow == stage.length - 1 ? 0 : IntStream.rangeClosed(startCol, endCol).map(c -> stage[endRow + 1][c]).sum();
        int left = startCol == 0 ? 0 : IntStream.rangeClosed(startRow, endRow).map(r -> stage[r][startCol - 1]).sum();
        int right = endCol == stage[0].length - 1 ? 0 : IntStream.rangeClosed(startRow, endRow).map(r -> stage[r][endCol + 1]).sum();

        int energy = 0;
        char direction = ' ';
        if (up > energy) {
            energy = up;
            direction = 'U';
        }
        if (down > energy) {
            energy = down;
            direction = 'D';
        }
        if (left > energy) {
            energy = left;
            direction = 'L';
        }
        if (right > energy) {
            energy = right;
            direction = 'R';
        }

        this.energy += energy;
        switch (direction) {
            case 'U' -> startRow--;
            case 'D' -> endRow++;
            case 'L' -> startCol--;
            case 'R' -> endCol++;
        }

        return direction;
    }

    public int getEnergy() {
        return energy;
    }
}