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
        int singerNum = Integer.parseInt(tokenizer.nextToken());
        int pdNum = Integer.parseInt(tokenizer.nextToken());

        int[] preSingerNum = new int[singerNum + 1];
        Map<Integer, Set<Integer>> nextSingers = IntStream.rangeClosed(1, singerNum).boxed()
                .collect(Collectors.toMap(n -> n, n -> new HashSet<>()));

        while (pdNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int sortedSingerNum = Integer.parseInt(tokenizer.nextToken());
            int preSinger = Integer.parseInt(tokenizer.nextToken()), postSinger;
            while (sortedSingerNum-- > 1) {
                postSinger = Integer.parseInt(tokenizer.nextToken());
                if (nextSingers.get(preSinger).add(preSinger = postSinger)) preSingerNum[postSinger]++;
            }
        }

        List<Integer> singers = new ArrayList<>();
        Queue<Integer> prepared = IntStream.rangeClosed(1, singerNum)
                .filter(n -> preSingerNum[n] == 0).boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        while (!prepared.isEmpty()) {
            int node = prepared.poll();
            singers.add(node);
            nextSingers.get(node).stream()
                    .peek(n -> preSingerNum[n]--)
                    .filter(n -> preSingerNum[n] == 0)
                    .forEach(prepared::offer);
        }

        result.append(singers.size() == singerNum ?
                singers.stream().map(String::valueOf).collect(Collectors.joining(" ")) : 0);
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
