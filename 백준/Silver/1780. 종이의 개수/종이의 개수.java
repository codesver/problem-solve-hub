import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][] paper;
    private static int[] counter = new int[3];

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        paper = new int[N][N];
        initPaper(N);
        cut(N, 0, 0);
        result.append(counter[0]).append("\n").append(counter[1]).append("\n").append(counter[2]);
    }

    private static void initPaper(int N) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++)
                paper[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void cut(int size, int startI, int startJ) {
        int material = paper[startI][startJ];
        Cutter:
        for (int i = startI; i < startI + size; i++)
            for (int j = startJ; j < startJ + size; j++)
                if (paper[i][j] != material) {
                    for (int si = startI; si < startI + size; si += size / 3)
                        for (int sj = startJ; sj < startJ + size; sj += size / 3)
                            cut(size / 3, si, sj);
                    break Cutter;
                } else if (i == startI + size - 1 && j == startJ + size - 1)
                    counter[material + 1]++;
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