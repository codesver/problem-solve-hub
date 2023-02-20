import java.io.*;
import java.util.stream.IntStream;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        String[] drawing = new String[N + 1];
        drawing[1] = "  *  ";
        drawing[2] = " * * ";
        drawing[3] = "*****";

        for (int i = 1; 3 * Math.pow(2, i) <= N; i++) {
            int bottom = (int) (3 * Math.pow(2, i));
            int middle = bottom / 2;
            for (int j = middle + 1; j <= bottom; j++) drawing[j] = drawing[j - middle] + " " + drawing[j - middle];
            String space = " ".repeat(middle);
            for (int j = 1; j <= middle; j++) drawing[j] = space + drawing[j] + space;
        }

        IntStream.range(1, drawing.length).forEach(draw -> result.append(drawing[draw]).append("\n"));
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