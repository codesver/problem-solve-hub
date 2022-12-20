import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[] board;
    private static boolean[] visited;
    private static Queue<Location> locations;

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int ladderNum = Integer.parseInt(tokenizer.nextToken());
        int snakeNum = Integer.parseInt(tokenizer.nextToken());
        board = IntStream.rangeClosed(0, 101).toArray();
        visited = new boolean[105];

        int specialMove = ladderNum + snakeNum;
        while (specialMove-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            board[Integer.parseInt(tokenizer.nextToken())] = Integer.parseInt(tokenizer.nextToken());
        }

        visited[1] = true;
        locations = new LinkedList<>(Collections.singleton(new Location(1, 0)));
        while (!locations.isEmpty()) {
            Location location = locations.poll();
            if (location.num == 100) {
                result.append(location.time);
                break;
            } else for (int dice = 1; dice <= 6; dice++) rollDice(location, dice);
        }
    }

    private static void rollDice(Location location, int dice) {
        if (location.num + dice <= 100 && !visited[location.num + dice]) {
            locations.add(new Location(board[location.num + dice], location.time + 1));
            visited[location.num + dice] = true;
        }
    }

    static class Location {
        int num;
        int time = 0;

        public Location(int num, int time) {
            this.num = num;
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