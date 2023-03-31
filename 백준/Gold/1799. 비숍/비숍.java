import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    static class Grid {
        int row, col;
        boolean present;

        public Grid(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;

        List<Grid> blackGrids = new LinkedList<>();
        List<Grid> whiteGrids = new LinkedList<>();

        for (int r = 0; r < N; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; c++) {
                if (Integer.parseInt(tokenizer.nextToken()) == 1) {
                    if ((r + c) % 2 == 0) blackGrids.add(new Grid(r, c));
                    else whiteGrids.add(new Grid(r, c));
                }
            }
        }

        int black = search(blackGrids, 0, 0);
        int white = search(whiteGrids, 0, 0);
        result.append(black + white);
    }

    private int search(List<Grid> grids, int index, int count) {
        int maxCount = count;
        loop:
        for (int idx = index; idx < grids.size(); idx++) {
            Grid grid = grids.get(idx);
            for (int g = 0; g < index; g++) {
                Grid preGrid = grids.get(g);
                if (preGrid.present && Math.abs(grid.row - preGrid.row) == Math.abs(grid.col - preGrid.col)) {
                    continue loop;
                }
            }
            grid.present = true;
            maxCount = Math.max(maxCount, search(grids, idx + 1, count + 1));
            grid.present = false;
        }
        return maxCount;
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