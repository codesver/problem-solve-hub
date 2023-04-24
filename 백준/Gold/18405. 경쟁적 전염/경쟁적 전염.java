import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private final static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class TestTube {

        private final int[][] tube;

        public TestTube(int size) {
            tube = new int[size][size];
        }

        public void addVirus(int row, int col, int virus) {
            tube[row][col] = virus;
        }

        public void proliferation() {
            for (int row = 0; row < tube.length; row++)
                for (int col = 0; col < tube.length; col++)
                    if (tube[row][col] > 0) proliferation(row, col);
            for (int row = 0; row < tube.length; row++)
                for (int col = 0; col < tube.length; col++)
                    tube[row][col] = Math.abs(tube[row][col]);
        }

        private void proliferation(int row, int col) {
            for (int m = 0; m < 4; m++) {
                try {
                    int virus = tube[row + moves[m][0]][col + moves[m][1]];
                    if (virus == 0 || (virus < 0 && -virus > tube[row][col]))
                        tube[row + moves[m][0]][col + moves[m][1]] = -tube[row][col];
                } catch (ArrayIndexOutOfBoundsException ignore) {
                }
            }
        }

        public int searchVirus(int row, int col) {
            return tube[row][col];
        }
    }

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int size = Integer.parseInt(tokenizer.nextToken());
        TestTube testTube = new TestTube(size);

        for (int row = 0; row < size; row++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int col = 0; col < size; col++)
                testTube.addVirus(row, col, Integer.parseInt(tokenizer.nextToken()));
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int time = Integer.parseInt(tokenizer.nextToken());
        int targetRow = Integer.parseInt(tokenizer.nextToken()) - 1;
        int targetCol = Integer.parseInt(tokenizer.nextToken()) - 1;

        int virus = testTube.searchVirus(targetRow, targetCol);
        while (time-- > 0 && virus == 0) {
            testTube.proliferation();
            virus = testTube.searchVirus(targetRow, targetCol);
        }
        result.append(virus);
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