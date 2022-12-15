import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][] paper;
    private static final int[] counter = new int[2];

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        paper = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < size; j++) paper[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
        cut(size, 0, 0);
        result.append(counter[0]).append("\n").append(counter[1]);
    }

    private static void cut(int size, int startI, int startJ) {
        int color = paper[startI][startJ];
        cutter:
        for (int pi = startI; pi < startI + size; pi++)
            for (int pj = startJ; pj < startJ + size; pj++)
                if (paper[pi][pj] != color) {
                    for (int si = startI; si < startI + size; si += size / 2)
                        for (int sj = startJ; sj < startJ + size; sj += size / 2) cut(size / 2, si, sj);
                    break cutter;
                } else if (pi == startI + size - 1 && pj == startJ + size - 1) counter[color]++;
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