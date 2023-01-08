import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int N, M;
    private static final List<Integer> nums = new ArrayList<>();
    private static final List<Boolean> visited = new ArrayList<>();
    private static final Deque<Integer> deque = new LinkedList<>();
    private static final Set<String> set = new HashSet<>();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) {
            nums.add(Integer.parseInt(tokenizer.nextToken()));
            visited.add(false);
        }
        nums.sort(Comparator.naturalOrder());
        searchNext();
    }

    private static void search() {
        if (deque.size() == M) {
            StringBuilder builder = new StringBuilder();
            IntStream.range(0, M).forEach(len -> {
                builder.append(deque.peekFirst()).append(" ");
                deque.addLast(deque.pollFirst());
            });
            String string = builder.toString();
            if (!set.contains(string)) {
                result.append(string).append("\n");
                set.add(string);
            }
        } else searchNext();
    }

    private static void searchNext() {
        IntStream.range(0, N).forEach(idx -> {
            if (!visited.get(idx)) {
                deque.addLast(nums.get(idx));
                visited.set(idx, true);
                search();
                deque.pollLast();
                visited.set(idx, false);
            }
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