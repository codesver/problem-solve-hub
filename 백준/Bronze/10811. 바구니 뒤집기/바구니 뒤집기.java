import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        List<Integer> baskets = IntStream.rangeClosed(0, Integer.parseInt(tokenizer.nextToken())).boxed().collect(Collectors.toList());
        int M = Integer.parseInt(tokenizer.nextToken());
        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            Collections.reverse(baskets.subList(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()) + 1));
        }
        result.append(baskets.subList(1, baskets.size()).stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public void finish() throws IOException {
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