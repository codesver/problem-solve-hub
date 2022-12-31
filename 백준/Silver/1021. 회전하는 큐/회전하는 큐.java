import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        Queue<Integer> queue = IntStream.rangeClosed(1, N)
                .boxed().collect(Collectors.toCollection(LinkedList::new));
        tokenizer = new StringTokenizer(reader.readLine());
        int min = 0;
        while (M-- > 0) {
            int search = Integer.parseInt(tokenizer.nextToken());
            int count = 0;
            while (!queue.isEmpty()) {
                Integer found = queue.poll();
                if (search == found) break;
                else queue.add(found);
                count++;
            }
            min += Math.min(count, queue.size() + 1 - count);
        }
        result.append(min);
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