import java.io.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        if (N == 0) result.append(0);
        else {
            int[] fibonacci = new int[N + 1];
            fibonacci[1] = 1;
            for (int n = 2; n <= N; n++) fibonacci[n] = (fibonacci[n - 1] + fibonacci[n - 2]) % 1_000_000_007;
            result.append(fibonacci[N]);
        }
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