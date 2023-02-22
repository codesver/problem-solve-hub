import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public int N;
    public final int MOD = 1_000;

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        long pow = Long.parseLong(tokenizer.nextToken());
        int[][] matrix = new int[N][N];
        for (int r = 0; r < N; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; c++) matrix[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        int[][] res = power(matrix, pow);
        for (int[] re : res) {
            for (int r : re) result.append(r).append(" ");
            result.append("\n");
        }
    }

    private int[][] power(int[][] matrix, long pow) {
        int[][] res = new int[N][N];
        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++) if (r == c) res[r][c] = 1;
        while (pow > 0) {
            if (pow % 2 == 1) res = multiply(res, matrix);
            pow /= 2;
            matrix = multiply(matrix, matrix);
        }
        return res;
    }

    private int[][] multiply(int[][] ma, int[][] mb) {
        return IntStream.range(0, N).mapToObj(r ->
                        IntStream.range(0, N).map(c ->
                                IntStream.range(0, N).map(k ->
                                        ma[r][k] * mb[k][c] % MOD).sum() % MOD).toArray())
                .toArray(int[][]::new);
    }

    public void finish() throws IOException {
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