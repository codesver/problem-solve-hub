import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        long[] length = new long[101];
        length[1] = 1L;
        length[2] = 1L;
        length[3] = 1L;
        for (int i = 4; i <= 100; i++) length[i] = length[i - 3] + length[i - 2];
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) result.append(length[Integer.parseInt(reader.readLine())]).append("\n");
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