import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] inDegrees = new int[N + 1];
        Map<Integer, Set<Integer>> map = IntStream.rangeClosed(1, N).boxed()
                .collect(Collectors.toMap(n -> n, n -> new HashSet<>()));

        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int smaller = Integer.parseInt(tokenizer.nextToken());
            int bigger = Integer.parseInt(tokenizer.nextToken());

            inDegrees[bigger]++;
            map.get(smaller).add(bigger);
        }

        int count = N;
        while (count != 0) {
            for (int n = 1; n <= N; n++) {
                if (inDegrees[n] == 0) {
                    inDegrees[n]--;
                    result.append(n).append(" ");
                    count--;
                    for (Integer bigger : map.get(n)) inDegrees[bigger]--;
                }
            }
        }
    }

    private void finish() throws IOException {
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