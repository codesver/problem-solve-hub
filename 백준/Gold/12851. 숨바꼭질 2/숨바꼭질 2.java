import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, Integer> map = new HashMap<>() {{
            put(N, 0);
        }};
        Queue<X> xes = new LinkedList<>(Collections.singleton(new X(N, 0)));

        int time = 0, count = 0;
        while (!xes.isEmpty()) {
            X x = xes.poll();
            if (time != 0 && time < x.t) break;
            if (x.x == M) {
                time = x.t;
                count++;
            }
            if (x.x - 1 >= 0 && map.getOrDefault(x.x - 1, Integer.MAX_VALUE) >= x.t + 1) {
                if (!map.containsKey(x.x - 1)) map.put(x.x - 1, x.t + 1);
                xes.add(new X(x.x - 1, x.t + 1));
            }
            if (x.x + 1 <= M && map.getOrDefault(x.x + 1, Integer.MAX_VALUE) >= x.t + 1) {
                if (!map.containsKey(x.x + 1)) map.put(x.x + 1, x.t + 1);
                xes.add(new X(x.x + 1, x.t + 1));
            }
            if (x.x < M && map.getOrDefault(x.x * 2, Integer.MAX_VALUE) >= x.t + 1) {
                if (!map.containsKey(x.x * 2)) map.put(x.x * 2, x.t + 1);
                xes.add(new X(x.x * 2, x.t + 1));
            }
        }
        result.append(time).append("\n").append(count);
    }

    static class X {
        int x, t;

        public X(int x, int t) {
            this.x = x;
            this.t = t;
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