import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long from = Long.parseLong(tokenizer.nextToken());
        long to = Long.parseLong(tokenizer.nextToken());

        long minCount = -1;
        Queue<Num> queue = new LinkedList<>(Collections.singleton(new Num(from, 1)));
        while (!queue.isEmpty()) {
            Num num = queue.poll();
            if (num.value * 2 == to || num.value * 10 + 1 == to) {
                minCount = num.count + 1;
                break;
            } else {
                if (num.value * 2 <= to) queue.add(new Num(num.value * 2, num.count + 1));
                if (num.value * 10 + 1 <= to) queue.add(new Num(num.value * 10 + 1, num.count + 1));
            }
        }
        result.append(minCount);
    }

    static class Num {
        long value, count;

        public Num(long value, long count) {
            this.value = value;
            this.count = count;
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