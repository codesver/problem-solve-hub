import java.io.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int money = Integer.parseInt(reader.readLine());
        int[] coins = new int[money + 1];
        for (int c = 1; c < coins.length; c++) {
            if (c < 5) coins[c] = c % 2 == 0 ? c / 2 : -1;
            else {
                int addTwoCoin = coins[c - 2] == -1 ? -1 : coins[c - 2] + 1;
                int addFiveCoin = coins[c - 5] == -1 ? -1 : coins[c - 5] + 1;
                if (addTwoCoin + addFiveCoin == -2) coins[c] = -1;
                else if (addTwoCoin == -1) coins[c] = addFiveCoin;
                else if (addFiveCoin == - 1) coins[c] = addTwoCoin;
                else coins[c] = Math.min(addTwoCoin, addFiveCoin);
            }
        }
        result.append(coins[money]);
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