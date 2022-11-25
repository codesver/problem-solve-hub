import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int repeat = Integer.parseInt(reader.readLine());

        while (repeat-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int size = Integer.parseInt(tokenizer.nextToken());

            List<Integer> scores = new ArrayList<>();
            int sum = 0;
            while (tokenizer.hasMoreTokens()) {
                int score = Integer.parseInt(tokenizer.nextToken());
                scores.add(score);
                sum += score;
            }

            double average = sum / (double) size;
            int overAverage = 0;
            for (Integer score : scores) overAverage += score > average ? 1 : 0;
            double ratio = overAverage / (double) size * 100;

            result.append(String.format("%.3f", ratio)).append("%").append("\n");
        }
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

