import java.io.*;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        char[][] print = new char[N][N];
        draw(print, 0, 0, N);
        for (char[] stars : print) {
            IntStream.range(0, stars.length).forEach(i -> result.append(stars[i] == '*' ? '*' : ' '));
            result.append('\n');
        }
    }

    private void draw(char[][] print, int x, int y, int N) {
        if (N == 1) print[x][y] = '*';
        else for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (!(i == 1 && j == 1))
                    draw(print, x + i * (N / 3), y + j * (N / 3), N / 3);
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