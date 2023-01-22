import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int N, M;
    private static boolean[] visited;
    private static Deque<Integer> pairs = new LinkedList<>();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[N + 1];

        for (int num = 1; num <= N; num++) {
            visited[num] = true;
            pairs.addLast(num);
            search(1);
            visited[num] = false;
            pairs.pollLast();
        }
    }
    
    private static void search(int size) {
        if (size == M) {
            for (int i = 0; i < M; i++) {
                result.append(pairs.peekFirst()).append(" ");
                pairs.addLast(pairs.pollFirst());
            }
            result.append("\n");
        } else {
            for (int num = 1; num <= N; num++) {
                if (!visited[num]) {
                    visited[num] = true;
                    pairs.addLast(num);
                    search(size + 1);
                    visited[num] = false;
                    pairs.pollLast();
                }
            }
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