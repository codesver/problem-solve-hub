import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        final int MAX_COIN_NUMBER = 10_001;
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] coins = new int[Integer.parseInt(tokenizer.nextToken())];
        int[] coinNumbers = IntStream.range(0, Integer.parseInt(tokenizer.nextToken()) + 1)
                .map(i -> i > 0 ? MAX_COIN_NUMBER : 0).toArray();
        for (int c = 0; c < coins.length; c++) coins[c] = Integer.parseInt(reader.readLine());

        for (int value = 1; value < coinNumbers.length; value++)
            for (int coin : coins)
                if (coin <= value)
                    coinNumbers[value] = Math.min(coinNumbers[value], coinNumbers[value - coin] + 1);

        int coinNumber = coinNumbers[coinNumbers.length - 1];
        result.append(coinNumber == MAX_COIN_NUMBER ? -1 : coinNumber);
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