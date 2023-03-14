import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    int[][] state;
    char[][] map;

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        state = new int[R][C];
        map = new char[R][C];
        for (int r = 0; r < R; r++) map[r] = reader.readLine().toCharArray();

        int count = 0;
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                if (state[r][c] == 0 && search(r, c)) count++;

        result.append(count);
    }

    private boolean search(int r, int c) {
        int state = this.state[r][c];
        this.state[r][c] = 1;

        boolean flag;
        if (state == 1) flag = true;
        else if (state == 2) flag = false;
        else if (map[r][c] == 'U') flag = search(r - 1, c);
        else if (map[r][c] == 'R') flag = search(r, c + 1);
        else if (map[r][c] == 'D') flag = search(r + 1, c);
        else flag = search(r, c - 1);

        this.state[r][c] = 2;
        return flag;
    }

    private void finish() throws IOException {
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