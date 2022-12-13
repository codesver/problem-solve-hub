import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static boolean[][] farm;

    private static void solution() throws IOException {
        int test = Integer.parseInt(reader.readLine());
        while (test-- > 0) {
            initFarm();
            result.append(searchWarms()).append("\n");
        }
    }

    private static void initFarm() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int M = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());
        int count = Integer.parseInt(tokenizer.nextToken());

        farm = new boolean[N + 2][M + 2];
        while (count-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int X = Integer.parseInt(tokenizer.nextToken());
            int Y = Integer.parseInt(tokenizer.nextToken());
            farm[Y + 1][X + 1] = true;
        }
    }

    private static int searchWarms() {
        int warms = 0;
        for (int y = 1; y < farm.length - 1; y++) {
            for (int x = 1; x < farm[y].length - 1; x++) {
                if (!farm[y][x]) continue;
                warms++;
                searchFarm(y, x);
            }
        }
        return warms;
    }

    private static void searchFarm(int y, int x) {
        farm[y][x] = false;
        if (farm[y][x - 1]) searchFarm(y, x - 1);
        if (farm[y + 1][x]) searchFarm(y + 1, x);
        if (farm[y][x + 1]) searchFarm(y, x + 1);
        if (farm[y - 1][x]) searchFarm(y - 1, x);
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