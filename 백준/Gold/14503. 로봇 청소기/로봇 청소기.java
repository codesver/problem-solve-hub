import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    int[] robot;
    int[][] map;

    public void solve() throws IOException {
        init();
        result.append(cleanUp());
    }

    private int cleanUp() {
        int cleaned = 0;
        while (true) {
            if (map[robot[0]][robot[1]] == 0) cleaned++;
            map[robot[0]][robot[1]] = 2;
            if (checkAround()) continue;
            if (checkBack()) break;
        }
        return cleaned;
    }

    private boolean checkAround() {
        for (int m = 0; m < 4; m++) {
            robot[2] = (robot[2] + 3) % 4;
            try {
                if (map[robot[0] + moves[robot[2]][0]][robot[1] + moves[robot[2]][1]] == 0) {
                    robot[0] += moves[robot[2]][0];
                    robot[1] += moves[robot[2]][1];
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException ignore){
            }
        }
        return false;
    }

    private boolean checkBack() {
        try {
            if (map[robot[0] + moves[(robot[2] + 2) % 4][0]][robot[1] + moves[(robot[2] + 2) % 4][1]] != 1) {
                robot[0] += moves[(robot[2] + 2) % 4][0];
                robot[1] += moves[(robot[2] + 2) % 4][1];
            } else return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        return false;
    }

    private void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        robot = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < M; c++) map[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
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