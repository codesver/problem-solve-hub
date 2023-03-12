import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        final int T = Integer.parseInt(reader.readLine());

        int N = Integer.parseInt(reader.readLine());
        int[] A = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(reader.readLine());
        int[] B = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> AS = new HashMap<>();
        for (int as = 0; as < A.length; as++) {
            int sum = 0;
            for (int ae = as; ae < A.length; ae++) AS.merge(sum += A[ae], 1, Integer::sum);
        }

        Map<Integer, Integer> BS = new HashMap<>();
        for (int bs = 0; bs < B.length; bs++) {
            int sum = 0;
            for (int be = bs; be < B.length; be++) BS.merge(sum += B[be], 1, Integer::sum);
        }

        result.append(AS.entrySet().stream()
                .mapToLong(entry -> (long) BS.getOrDefault(T - entry.getKey(), 0) * entry.getValue())
                .sum());
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