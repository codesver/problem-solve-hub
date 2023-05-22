import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int money = Integer.parseInt(tokenizer.nextToken());
        int year = Integer.parseInt(tokenizer.nextToken());
        int[] moneys = new int[year + 1];
        moneys[0] = money;
        for(int y = 1; y <= year; y++) {
            moneys[y] = moneys[y - 1] * 105 / 100;
            if (y >= 3) moneys[y] = Math.max(moneys[y], moneys[y - 3] * 120 / 100);
            if (y >= 5) moneys[y] = Math.max(moneys[y], moneys[y - 5] * 135 / 100);
        }
        result.append(moneys[year]);
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