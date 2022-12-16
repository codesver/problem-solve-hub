import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][][] farm;
    private static int HEIGHT, ROW, COL;

    private static final Queue<Tomato> tomatoes = new LinkedList<>();
    private static int left = 0, time = 0;

    private static void solution() throws IOException {
        createFarm();
        plantSeeds();
        waitRipening();
        result.append(left == 0 ? time : -1);
    }

    private static void createFarm() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        COL = Integer.parseInt(tokenizer.nextToken());
        ROW = Integer.parseInt(tokenizer.nextToken());
        HEIGHT = Integer.parseInt(tokenizer.nextToken());
        farm = new int[HEIGHT + 2][ROW + 2][COL + 2];
    }

    private static void plantSeeds() throws IOException {
        StringTokenizer tokenizer;
        for (int h = 1; h <= HEIGHT; h++) {
            for (int r = 1; r <= ROW; r++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int c = 1; c <= COL; c++) {
                    int tomato = Integer.parseInt(tokenizer.nextToken());
                    if (tomato == 1) tomatoes.add(new Tomato(h, r, c, 0));
                    else if (tomato == -1) tomato = 0;
                    else if (tomato == 0) {
                        left++;
                        tomato = -1;
                    }
                    farm[h][r][c] = tomato;
                }
            }
        }
    }

    private static void waitRipening() {
        while (!tomatoes.isEmpty()) {
            Tomato tomato = tomatoes.poll();
            time = tomato.time;
            nextRipenTomato(tomato.height + 1, tomato.row, tomato.col, tomato);
            nextRipenTomato(tomato.height - 1, tomato.row, tomato.col, tomato);
            nextRipenTomato(tomato.height, tomato.row + 1, tomato.col, tomato);
            nextRipenTomato(tomato.height, tomato.row - 1, tomato.col, tomato);
            nextRipenTomato(tomato.height, tomato.row, tomato.col + 1, tomato);
            nextRipenTomato(tomato.height, tomato.row, tomato.col - 1, tomato);
        }
    }

    private static void nextRipenTomato(int height, int row, int col, Tomato tomato) {
        if (farm[height][row][col] == -1) {
            farm[height][row][col] = 1;
            left--;
            tomatoes.add(new Tomato(height, row, col, tomato.time + 1));
        }
    }

    static class Tomato {

        int height, row, col;
        int time;

        public Tomato(int height, int row, int col, int time) {
            this.height = height;
            this.row = row;
            this.col = col;
            this.time = time;
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