import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int R, C;
    private static int[][] lab, virus;
    private static int room = Integer.MIN_VALUE;

    private static void solution() throws IOException {
        init();
        block(0, 0, 0);
        result.append(room);
    }

    private static void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        lab = new int[R + 2][C + 2];
        for (int[] rooms : lab) Arrays.fill(rooms, 1);

        for (int r = 1; r <= R; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 1; c <= C; c++) lab[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void block(int sr, int sc, int count) {
        if (count == 3) {
            searchVirus();
            countRooms();
        } else for (int r = sr; r <= R; r++) {
            for (int c = r == sr ? sc : 1; c <= C; c++) {
                if (lab[r][c] == 0) {
                    lab[r][c] = 8;
                    block(c == C ? r + 1 : r, c == C ? 1 : c + 1, count + 1);
                    lab[r][c] = 0;
                }
            }
        }
    }

    private static void searchVirus() {
        virus = Arrays.stream(lab).map(int[]::clone).toArray(int[][]::new);

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (virus[r][c] == 2) infection(r, c);
            }
        }
    }

    private static void infection(int r, int c) {
        Queue<Room> rooms = new LinkedList<>(Collections.singleton(new Room(r, c)));
        while (!rooms.isEmpty()) {
            Room room = rooms.poll();
            infect(room.r - 1, room.c, rooms);
            infect(room.r, room.c + 1, rooms);
            infect(room.r + 1, room.c, rooms);
            infect(room.r, room.c - 1, rooms);
        }
    }

    private static void infect(int r, int c, Queue<Room> rooms) {
        if (virus[r][c] == 0) {
            virus[r][c] = 3;
            rooms.add(new Room(r, c));
        }
    }

    private static void countRooms() {
        room = Math.max(room, (int) Arrays.stream(virus).flatMapToInt(Arrays::stream).filter(r -> r == 0).count());
    }

    static class Room {
        int r, c;

        public Room(int r, int c) {
            this.r = r;
            this.c = c;
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