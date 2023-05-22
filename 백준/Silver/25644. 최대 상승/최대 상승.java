import java.io.*;
import java.util.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[] stock = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] profits = new int[N];
        int maxProfit = 0;
        for(int i = 1; i < N; i++) {
            profits[i] = Math.max(0, profits[i - 1] + stock[i] - stock[i - 1]);
            maxProfit = Math.max(maxProfit, profits[i]);
        }
        result.append(maxProfit);
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