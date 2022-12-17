import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][] farm;
    private static int HEIGHT, WIDTH;

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
        WIDTH = Integer.parseInt(tokenizer.nextToken());
        HEIGHT = Integer.parseInt(tokenizer.nextToken());
        farm = new int[HEIGHT + 2][WIDTH + 2];
    }

    private static void plantSeeds() throws IOException {
        StringTokenizer tokenizer;
        for (int height = 1; height <= HEIGHT; height++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int width = 1; width <= WIDTH; width++) {
                int tomato = Integer.parseInt(tokenizer.nextToken());
                if (tomato == 1) tomatoes.add(new Tomato(height, width, 0));
                else if (tomato == -1) tomato = 0;
                else if (tomato == 0) {
                    left++;
                    tomato = -1;
                }
                farm[height][width] = tomato;
            }
        }
    }

    private static void waitRipening() {
        while (!tomatoes.isEmpty()) {
            Tomato tomato = tomatoes.poll();
            time = tomato.time;
            nextRipenTomato(tomato.height + 1, tomato.width, tomato);
            nextRipenTomato(tomato.height - 1, tomato.width, tomato);
            nextRipenTomato(tomato.height, tomato.width + 1, tomato);
            nextRipenTomato(tomato.height, tomato.width - 1, tomato);
        }
    }

    private static void nextRipenTomato(int height, int width, Tomato tomato) {
        if (farm[height][width] == -1) {
            farm[height][width] = 1;
            left--;
            tomatoes.add(new Tomato(height, width, tomato.time + 1));
        }
    }

    static class Tomato {

        int height, width;
        int time;

        public Tomato(int height, int width, int time) {
            this.height = height;
            this.width = width;
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