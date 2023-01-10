import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int cnum = Integer.parseInt(reader.readLine());
        int bnum = Integer.parseInt(reader.readLine());

        final int[][] map = new int[cnum + 1][cnum + 1];
        final int[] distances = new int[cnum + 1];
        final boolean[] visited = new boolean[cnum + 1];
        for (int[] m : map) Arrays.fill(m, Integer.MAX_VALUE);
        Arrays.fill(distances, Integer.MAX_VALUE);

        StringTokenizer tokenizer;
        while (bnum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());
            map[from][to] = Math.min(map[from][to], cost);
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int from = Integer.parseInt(tokenizer.nextToken());
        int to = Integer.parseInt(tokenizer.nextToken());
        distances[from] = 0;

        while (true) {
            int minDistance = Integer.MAX_VALUE;
            int cno = 0;
            for (int c = 1; c <= cnum; c++) {
                if (!visited[c] && minDistance > distances[c]) {
                    minDistance = distances[c];
                    cno = c;
                }
            }
            if (cno == 0) break;
            visited[cno] = true;

            for (int c = 1; c <= cnum; c++)
                if (!visited[c] && map[cno][c] != Integer.MAX_VALUE)
                    distances[c] = Math.min(distances[c], distances[cno] + map[cno][c]);
        }

        result.append(distances[to]);
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