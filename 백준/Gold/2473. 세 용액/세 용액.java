import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        long[] values = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        long max = Long.MAX_VALUE;
        long[] maxValues = new long[3];

        for (int i = 0; i < N; i++) {
            int s = i + 1;
            int e = N - 1;

            while (s < e) {
                long sum = values[i] + values[s] + values[e];
                if (max > Math.abs(sum)) {
                    max = Math.abs(sum);
                    maxValues[0] = values[i];
                    maxValues[1] = values[s];
                    maxValues[2] = values[e];
                }
                if (sum > 0) e--;
                else s++;
            }
        }

        result.append(Arrays.stream(maxValues).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    private void finish() throws IOException {
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