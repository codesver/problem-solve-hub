import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Queue<X> xs = new LinkedList<>(Collections.singleton(new X(Integer.parseInt(reader.readLine()), 0)));
        while (!xs.isEmpty()) {
            X x = xs.poll();
            if (x.x == 1) {
                result.append(x.step);
                break;
            }
            if (x.x % 3 == 0) xs.add(new X(x.x / 3, x.step + 1));
            if (x.x % 2 == 0) xs.add(new X(x.x / 2, x.step + 1));
            xs.add(new X(x.x - 1, x.step + 1));
        }
    }

    static class X {
        int x, step;

        public X(int x, int step) {
            this.x = x;
            this.step = step;
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