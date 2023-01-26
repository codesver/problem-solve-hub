import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static final TreeMap<Integer, Integer> sets = new TreeMap<>(Comparator.reverseOrder());

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(tokenizer.nextToken());
        int col = Integer.parseInt(tokenizer.nextToken());
        int initInven = Integer.parseInt(tokenizer.nextToken());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (row-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            while (tokenizer.hasMoreTokens()) {
                int height = Integer.parseInt(tokenizer.nextToken());
                max = Math.max(max, height);
                min = Math.min(min, height);
                sets.put(height, sets.getOrDefault(height, 0) + 1);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;

        int inven, time, blocks;
        Loop:
        for (int h = max; h >= min; h--) {
            inven = initInven;
            time = 0;
            for (Map.Entry<Integer, Integer> set : sets.entrySet()) {
                blocks = Math.abs(set.getKey() - h) * set.getValue();
                if (set.getKey() >= h) {
                    inven += blocks;
                    time += 2 * blocks;
                } else if (blocks <= inven) {
                    inven -= blocks;
                    time += blocks;
                } else continue Loop;
            }

            if (minTime > time) {
                minTime = time;
                height = h;
            }
        }

        result.append(minTime).append(" ").append(height);
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