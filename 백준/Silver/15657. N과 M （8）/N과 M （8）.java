import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int N, M;
    private static final List<Integer> nums = new ArrayList<>();
    private static final Deque<Integer> deque = new LinkedList<>();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) nums.add(Integer.parseInt(tokenizer.nextToken()));
        nums.sort(Comparator.naturalOrder());
        searchNext(0);
    }

    private static void search(int start) {
        if (deque.size() == M) {
            IntStream.range(0, M).forEach(len -> {
                result.append(deque.peekFirst()).append(" ");
                deque.addLast(deque.pollFirst());
            });
            result.append("\n");
        } else searchNext(start);
    }

    private static void searchNext(int start) {
        IntStream.range(start, N).forEach(idx -> {
            deque.addLast(nums.get(idx));
            search(idx);
            deque.pollLast();
        });
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