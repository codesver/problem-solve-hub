import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int R, C;
    private static int purifier;
    private static int[][] room, spread;

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        int T = Integer.parseInt(tokenizer.nextToken());

        room = new int[R][C];
        spread = new int[R][C];

        for (int r = 0; r < R; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < C; c++) {
                if ((room[r][c] = Integer.parseInt(tokenizer.nextToken())) == -1) purifier = r;
            }
        }

        while (T-- > 0) {
            spread();
            merge();
            blow();
        }

        result.append(Arrays.stream(room).mapToInt(s -> Arrays.stream(s).sum()).sum() + 2);
    }

    private static void spread() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (room[r][c] > 0) {
                    int dust = room[r][c] / 5;
                    if (r > 0 && room[r - 1][c] != -1) {
                        spread[r - 1][c] += dust;
                        room[r][c] -= dust;
                    }
                    if (c > 0 && room[r][c - 1] != -1) {
                        spread[r][c - 1] += dust;
                        room[r][c] -= dust;
                    }
                    if (r < R - 1 && room[r + 1][c] != -1) {
                        spread[r + 1][c] += dust;
                        room[r][c] -= dust;
                    }
                    if (c < C - 1&& room[r][c + 1] != -1) {
                        spread[r][c + 1] += dust;
                        room[r][c] -= dust;
                    }
                }
            }
        }
    }

    private static void merge() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                room[r][c] += spread[r][c];
                spread[r][c] = 0;
            }
        }
    }

    private static void blow() {
        for (int r = purifier - 2; r >= 1; r--) room[r][0] = room[r - 1][0];
        for (int c = 0; c < C - 1; c++) room[0][c] = room[0][c + 1];
        for (int r = 0; r < purifier - 1; r++) room[r][C - 1] = room[r + 1][C - 1];
        for (int c = C - 1; c > 1; c--) room[purifier - 1][c] = room[purifier - 1][c - 1];
        for (int r = purifier + 1; r < R - 1; r++) room[r][0] = room[r + 1][0];
        for (int c = 0; c < C - 1; c++) room[R - 1][c] = room[R - 1][c + 1];
        for (int r = R - 1; r > purifier; r--) room[r][C - 1] = room[r - 1][C - 1];
        for (int c = C - 1; c > 1; c--) room[purifier][c] = room[purifier][c - 1];
        room[purifier][1] = room[purifier - 1][1] = 0;
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