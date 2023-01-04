import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][] sea;
    private static boolean[][] visited;
    private static int fish = 0;
    private static int time = 0;

    private static void solution() throws IOException {
        Shark start = init();
        searchFish(start);
        result.append(time);
    }

    private static void searchFish(Shark start) {
        Queue<Shark> qa = new PriorityQueue<>((o1, o2) -> o1.row == o2.row ? o1.col - o2.col : o1.row - o2.row);
        Queue<Shark> qb = new PriorityQueue<>((o1, o2) -> o1.row == o2.row ? o1.col - o2.col : o1.row - o2.row);
        qa.add(start);

        while (!(qa.isEmpty() && qb.isEmpty()) && fish != 0) {
            swim(qa, qb);
            swim(qb, qa);
        }
    }

    private static void swim(Queue<Shark> from, Queue<Shark> to) {
        while (!from.isEmpty()) {
            Shark shark = from.poll();
            if (shark.edible()) {
                shark.eat();
                from.clear();
                to.clear();
                to.add(shark);
                time = shark.time;
                for (boolean[] visit : visited) Arrays.fill(visit, false);
            } else {
                if (shark.moveable(-1, 0)) shark.move(-1, 0, to);
                if (shark.moveable(0, 1)) shark.move(0, 1, to);
                if (shark.moveable(1, 0)) shark.move(1, 0, to);
                if (shark.moveable(0, -1)) shark.move(0, -1, to);
            }
        }
    }

    static class Shark {
        int row, col, time;
        int size, count;

        public Shark(int row, int col, int size, int time, int count) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.time = time;
            this.count = count;
        }

        public boolean edible() {
            return sea[row][col] != -1 && sea[row][col] < size;
        }

        public void eat() {
            fish--;
            sea[row][col] = -1;
            if (++count == size) {
                size++;
                count = 0;
            }
        }

        public boolean moveable(int r, int c) {
            int nextR = row + r;
            int nextC = col + c;
            return !visited[nextR][nextC] && sea[nextR][nextC] != 0 && sea[nextR][nextC] <= size;
        }

        public void move(int r, int c, Queue<Shark> to) {
            to.add(new Shark(row + r, col + c, size, time + 1, count));
            visited[row + r][col + c] = true;
        }
    }

    private static Shark init() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        sea = new int[n + 2][n + 2];
        visited = new boolean[n + 2][n + 2];

        Shark start = null;
        StringTokenizer tokenizer;
        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= n; j++) {
                int size = Integer.parseInt(tokenizer.nextToken());
                if (size == 0) sea[i][j] = -1;
                else if (size == 9) {
                    sea[i][j] = -1;
                    start = new Shark(i, j, 2, 0, 0);
                } else {
                    fish++;
                    sea[i][j] = size;
                }
            }
        }
        return start;
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