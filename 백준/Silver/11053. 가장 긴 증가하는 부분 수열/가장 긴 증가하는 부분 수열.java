import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        List<Integer> nums = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();

        int length = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) {
            nums.add(Integer.parseInt(tokenizer.nextToken()));
            lens.add(1);
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++)
                if (nums.get(j) < nums.get(i) && lens.get(i) <= lens.get(j))
                    lens.set(i, lens.get(j) + 1);
        }

        result.append(lens.stream().max(Comparator.naturalOrder()).orElseThrow());
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