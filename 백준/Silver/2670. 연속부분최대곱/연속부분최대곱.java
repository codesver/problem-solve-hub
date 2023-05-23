import java.io.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        double mul = 1, maxMul = 0;
        while (N-- > 0) {
            double num = Double.parseDouble(reader.readLine());
            maxMul = Math.max(maxMul, (mul = Math.max(mul * num, num)));
        }
        result.append(String.format("%.3f", maxMul));
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