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

        List<Integer> degrees = new ArrayList<>();
        Map<Integer, List<Integer>> next = new HashMap<>();

        for (int nno = 1; nno <= N; nno++) {
            degrees.add(0);
            next.put(nno, new ArrayList<>());
        }

        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int smaller = Integer.parseInt(tokenizer.nextToken());
            int bigger = Integer.parseInt(tokenizer.nextToken());
            degrees.set(bigger - 1, degrees.get(bigger - 1) + 1);
            next.get(smaller).add(bigger);
        }

        Queue<Integer> readies = IntStream.rangeClosed(1, N).boxed()
                .filter(n -> degrees.get(n - 1) == 0).collect(Collectors.toCollection(LinkedList::new));
        while (!readies.isEmpty()) {
            for (int nno : next.get(readies.peek()))
                if (degrees.set(nno - 1, degrees.get(nno - 1) - 1) == 1) readies.offer(nno);
            result.append(readies.poll()).append(" ");
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