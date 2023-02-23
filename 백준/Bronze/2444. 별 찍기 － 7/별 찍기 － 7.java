import java.io.*;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public int N;

    public void solve() throws IOException {
        N = Integer.parseInt(reader.readLine());
        for (int n = 1; n < N; n++) result.append(stars(n)).append("\n");
        result.append("*".repeat(N * 2 - 1)).append("\n");
        for (int n = N - 1; n > 0; n--) result.append(stars(n)).append("\n");
        result.deleteCharAt(result.length() - 1);
    }

    private String stars(int n) {
        return " ".repeat(N - n) + "*".repeat(n * 2 - 1);
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