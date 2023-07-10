import java.io.*;
import java.util.StringTokenizer;

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

    private int sr, sc, er, ec;
    private final int[][] stage;
    private int energy;

    private final char[] chars = {'U', 'D', 'L', 'R'};

    public DancePlant(int size, int[][] stage) {
        this.stage = stage;
        sr = sc = size / 2 - 1;
        er = ec = size / 2;
    }

    public char dance() {
        int maxEnergy = 0;
        char direction = ' ';
        for (int dir = 0; dir < 4; dir++) {
            int sum = sideSum(dir);
            if (sum > maxEnergy) {
                maxEnergy = sum;
                direction = chars[dir];
            }
        }

        energy += maxEnergy;
        switch (direction) {
            case 'U' -> sr--;
            case 'D' -> er++;
            case 'L' -> sc--;
            case 'R' -> ec++;
        }

        return direction;
    }

    private int sideSum(int dir) {
        return switch (dir) {
            case 0 -> sum(sc, ec, sr - 1, true);
            case 1 -> sum(sc, ec, er + 1, true);
            case 2 -> sum(sr, er, sc - 1, false);
            case 3 -> sum(sr, er, ec + 1, false);
            default -> throw new IllegalArgumentException("Should not reach here");
        };
    }

    private int sum(int from, int to, int base, boolean vertical) {
        try {
            int sum = 0;
            for (int i = from; i <= to; i++)
                sum += stage[vertical ? base : i][vertical ? i : base];
            return sum;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    public int getEnergy() {
        return energy;
    }
}