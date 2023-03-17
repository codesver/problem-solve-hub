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
        int nodeNum = Integer.parseInt(tokenizer.nextToken());
        int pdNum = Integer.parseInt(tokenizer.nextToken());

        int[] degrees = new int[nodeNum + 1];
        Map<Integer, Set<Integer>> nextNodes = IntStream.rangeClosed(1, nodeNum).boxed()
                .collect(Collectors.toMap(n -> n, n -> new HashSet<>()));

        while (pdNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int pd = Integer.parseInt(tokenizer.nextToken());
            int preNode = Integer.parseInt(tokenizer.nextToken()), postNode;
            while (pd-- > 1) {
                postNode = Integer.parseInt(tokenizer.nextToken());
                if (nextNodes.get(preNode).add(postNode)) degrees[postNode]++;
                preNode = postNode;
            }
        }

        List<Integer> sequence = new ArrayList<>();
        Queue<Integer> zeroes = IntStream.rangeClosed(1, nodeNum).filter(n -> degrees[n] == 0).boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        while (!zeroes.isEmpty()) {
            int node = zeroes.poll();
            sequence.add(node);
            nextNodes.get(node).stream().peek(n -> degrees[n]--).filter(n -> degrees[n] == 0).forEach(zeroes::offer);
        }

        result.append(sequence.size() == nodeNum ?
                sequence.stream().map(String::valueOf).collect(Collectors.joining(" ")) : 0);
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