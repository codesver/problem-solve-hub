import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int R, C, T = 0;
    private static int[][] papers;

    private static void solution() throws IOException {
        init();
        while (left()) {
            T++;
            corrosion();
            melt();
        }
        result.append(T);
    }

    private static void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        papers = new int[R + 2][C + 2];
        for (int[] paper : papers) Arrays.fill(paper, -1);
        for (int r = 1; r <= R; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 1; c <= C; c++) papers[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static boolean left() {
        for (int r = 1; r <= R; r++)
            for (int c = 1; c <= C; c++)
                if (papers[r][c] == 1) return true;
        return false;
    }

    private static void corrosion() {
        boolean[][] visited = new boolean[R + 2][C + 2];
        Queue<Point> points = new LinkedList<>(Collections.singleton(new Point(1, 1)));
        while (!points.isEmpty()) {
            Point point = points.poll();
            search(points, visited, point.r - 1, point.c);
            search(points, visited, point.r + 1, point.c);
            search(points, visited, point.r, point.c + 1);
            search(points, visited, point.r, point.c - 1);
        }
    }

    private static void search(Queue<Point> points, boolean[][] visited, int r, int c) {
        if (papers[r][c] >= 1) papers[r][c]++;
        else if (papers[r][c] == 0 && !visited[r][c]) {
            visited[r][c] = true;
            points.add(new Point(r, c));
        }
    }

    private static void melt() {
        for (int r = 1; r <= R; r++)
            for (int c = 1; c <= C; c++)
                if (papers[r][c] >= 3) papers[r][c] = 0;
                else if (papers[r][c] == 2) papers[r][c] = 1;
    }

    static class Point {

        int r, c;

        public Point(int r, int c) {
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