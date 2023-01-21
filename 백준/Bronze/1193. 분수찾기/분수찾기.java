import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int X = Integer.parseInt(reader.readLine());
        int x = 1;
        while (X > x) X -= x++;
        result.append(
                x % 2 == 0 ?
                        X + "/" + (x - X + 1) :
                        x - X + 1 + "/" + X
        );
    }

    private static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}