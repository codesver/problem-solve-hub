import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        final List<List<Integer>> tree = new ArrayList<>();
        IntStream.rangeClosed(0, N + 1).forEach(idx -> tree.add(new ArrayList<>()));

        int a, b;
        StringTokenizer tokenizer;
        for (int i = 1; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            a = Integer.parseInt(tokenizer.nextToken());
            b = Integer.parseInt(tokenizer.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        final int[] parent = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>(Collections.singleton(1));
        while (!queue.isEmpty()) {
            int num = queue.poll();
            List<Integer> children = tree.get(num);
            for (Integer child : children) {
                if (parent[child] == 0) {
                    parent[child] = num;
                    queue.add(child);
                }
            }
        }

        IntStream.rangeClosed(2, N).forEach(num -> result.append(parent[num]).append("\n"));
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