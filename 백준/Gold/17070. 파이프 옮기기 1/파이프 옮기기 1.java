import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int SIZE;
    private static boolean[][] walls;
    private static Tile[][] tiles;

    private static void solution() throws IOException {
        init();
        read();
        dp();
        result.append(tiles[SIZE][SIZE].total());
    }

    private static void init() throws IOException {
        SIZE = Integer.parseInt(reader.readLine());
        walls = new boolean[SIZE + 1][SIZE + 1];
        tiles = new Tile[SIZE + 1][SIZE + 1];
    }

    private static void read() throws IOException {
        StringTokenizer tokenizer;
        IntStream.rangeClosed(2, SIZE).forEach(col -> tiles[0][col] = new Tile(0, 0, 0));
        for (int r = 1; r <= SIZE; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 1; c <= SIZE; c++) {
                walls[r][c] = Integer.parseInt(tokenizer.nextToken()) == 1;
                tiles[r][c] = new Tile(0, 0, 0);
            }
        }
        tiles[1][2].setHVD(1, 0, 0);
    }

    private static void dp() {
        for (int r = 1; r <= SIZE; r++) {
            for (int c = 3; c <= SIZE; c++) {
                if (!walls[r][c]) {
                    Tile tileH = tiles[r][c - 1];
                    Tile tileV = tiles[r - 1][c];
                    tiles[r][c].setHVD(tileH.h + tileH.d, tileV.v + tileV.d,
                            walls[r - 1][c] || walls[r][c - 1] ? 0 : tiles[r - 1][c - 1].total());
                }
            }
        }
    }

    static class Tile {

        int h, v, d;

        public Tile(int h, int v, int d) {
            this.h = h;
            this.v = v;
            this.d = d;
        }

        public void setHVD(int h, int v, int d) {
            this.h = h;
            this.v = v;
            this.d = d;
        }

        public int total() {
            return h + v + d;
        }
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