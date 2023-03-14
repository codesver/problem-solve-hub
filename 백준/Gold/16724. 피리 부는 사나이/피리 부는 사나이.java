import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    char[][] map;

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        map = new char[R][C];
        for (int r = 0; r < R; r++) map[r] = reader.readLine().toCharArray();

        int count = 0;
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                if (map[r][c] != 'O' && map[r][c] != 'X' && search(r, c)) count++;

        result.append(count);
    }

    private boolean search(int r, int c) {
        char type = map[r][c];
        map[r][c] = 'X';

        boolean flag;
        if (type == 'X') flag = true;
        else if (type == 'O') flag = false;
        else if (type == 'U') flag = search(r - 1, c);
        else if (type == 'R') flag = search(r, c + 1);
        else if (type == 'D') flag = search(r + 1, c);
        else flag = search(r, c - 1);

        map[r][c] = 'O';
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