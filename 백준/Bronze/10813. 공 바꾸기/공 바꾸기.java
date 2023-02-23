import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] baskets = IntStream.rangeClosed(0, Integer.parseInt(tokenizer.nextToken())).toArray();
        int M = Integer.parseInt(tokenizer.nextToken());
        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int temp = baskets[a];
            baskets[a] = baskets[b];
            baskets[b] = temp;
        }
        result.append(IntStream.range(1, baskets.length).mapToObj(i -> String.valueOf(baskets[i])).collect(Collectors.joining(" ")));
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