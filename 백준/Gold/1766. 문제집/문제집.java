import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    final StringBuilder result = new StringBuilder();

    void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] degrees = new int[N + 1];
        Map<Integer, Set<Integer>> nextNodes = IntStream.rangeClosed(1, N).boxed()
                .collect(Collectors.toMap(i -> i, i -> new HashSet<>()));

        int pre, post;
        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            pre = Integer.parseInt(tokenizer.nextToken());
            post = Integer.parseInt(tokenizer.nextToken());
            degrees[post]++;
            nextNodes.get(pre).add(post);
        }

        Queue<Integer> readied = IntStream.rangeClosed(1, N).filter(n -> degrees[n] == 0).boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        while (!readied.isEmpty()) {
            int node = readied.poll();
            result.append(node).append(" ");
            for (int next : nextNodes.get(node)) if (--degrees[next] == 0) readied.offer(next);
        }
    }

    void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}