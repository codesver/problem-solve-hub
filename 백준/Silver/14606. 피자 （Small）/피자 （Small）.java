import java.io.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int pizzaHeight = Integer.parseInt(reader.readLine());
        int[] fun = new int[pizzaHeight + 1];
        for (int f = 1; f <= pizzaHeight; f++) {
            int heightA = f / 2;
            int heightB = f - heightA;
            fun[f] = heightA * heightB + fun[heightA] + fun[heightB];
        }
        result.append(fun[pizzaHeight]);
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