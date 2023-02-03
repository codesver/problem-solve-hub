import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int Z, R;
    private static int[][] field;
    private static int[] items;

    private static void solution() throws IOException {
        init();
        optimizeRange();
        result.append(maxItem());
    }

    private static void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        Z = Integer.parseInt(tokenizer.nextToken());
        R = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());

        field = new int[Z + 1][Z + 1];
        int INF = 15 * (Z - 1) + 1;
        for (int r = 1; r <= Z; r++) {
            for (int c = 1; c <= Z; c++) {
                if (r == c) field[r][c] = 0;
                else field[r][c] = field[c][r] = INF;
            }
        }

        items = Arrays.stream(("0 " + reader.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        while (L-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int zoneA = Integer.parseInt(tokenizer.nextToken());
            int zoneB = Integer.parseInt(tokenizer.nextToken());
            int range = Integer.parseInt(tokenizer.nextToken());
            field[zoneA][zoneB] = field[zoneB][zoneA] = range;
        }
    }

    private static void optimizeRange() {
        for (int pass = 1; pass <= Z; pass++)
            for (int from = 1; from <= Z; from++)
                for (int to = 1; to <= Z; to++)
                    if (field[from][to] > field[from][pass] + field[pass][to])
                        field[from][to] = field[to][from] = field[from][pass] + field[pass][to];
    }

    private static int maxItem() {
        int max = Integer.MIN_VALUE;
        for (int r = 1; r <= Z; r++) {
            int sum = 0;
            for (int c = 1; c <= Z; c++) {
                if (field[r][c] <= R) sum += items[c];
            }
            max = Math.max(max, sum);
        }
        return max;
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