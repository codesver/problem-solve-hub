import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int testCase = Integer.parseInt(reader.readLine());
        while (testCase-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            Queue<Number> queue = new LinkedList<>();
            Queue<Number> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

            tokenizer = new StringTokenizer(reader.readLine());
            for (int index = 0; index < n; index++) {
                Number number = new Number(Integer.parseInt(tokenizer.nextToken()), index);
                queue.add(number);
                priorityQueue.add(number);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                assert !priorityQueue.isEmpty();
                if (queue.peek().value == priorityQueue.peek().value) {
                    count++;
                    Number number = queue.poll();
                    priorityQueue.poll();
                    if (number.index == m) break;
                } else {
                    queue.add(queue.poll());
                }
            }

            result.append(count).append("\n");
        }
    }

    static class Number {
        int value = -1;
        int index = -1;

        public Number(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
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