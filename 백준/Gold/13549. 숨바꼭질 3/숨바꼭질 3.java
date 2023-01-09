import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int from = Integer.parseInt(tokenizer.nextToken());
        int to = Integer.parseInt(tokenizer.nextToken());
        final int MAX = 100001;
        boolean[] visited = new boolean[MAX + 1];

        Queue<Loc> locs = new LinkedList<>(Collections.singleton(new Loc(from, 0)));
        int min = Integer.MAX_VALUE;
        while (!locs.isEmpty()) {
            Loc loc = locs.poll();
            visited[loc.value] = true;
            if (loc.value == to) min = Math.min(min, loc.time);
            if (loc.value * 2 <= MAX && !visited[loc.value * 2])
                locs.add(new Loc(loc.value * 2, loc.time));
            if (loc.value + 1 <= MAX && !visited[loc.value + 1])
                locs.add(new Loc(loc.value + 1, loc.time + 1));
            if (loc.value - 1 >= 0 && !visited[loc.value - 1])
                locs.add(new Loc(loc.value - 1, loc.time + 1));
        }
        result.append(min);
    }

    static class Loc {
        int value, time;

        public Loc(int value, int time) {
            this.value = value;
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