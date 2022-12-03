import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());

        List<Integer> lengths = new ArrayList<>();
        long max = Long.MIN_VALUE;
        long min = 1;

        while (k-- > 0) {
            int length = Integer.parseInt(reader.readLine());
            lengths.add(length);
            max = Math.max(max, length);
        }

        while (min <= max) {
            long half = (min + max) / 2;
            long count = 0;

            for (Integer length : lengths) count += length / half;

            if (count < n) max = half - 1;
            else min = half + 1;
        }

        result.append((max + min) / 2);
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