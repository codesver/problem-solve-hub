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
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numberOfTrees = Integer.parseInt(tokenizer.nextToken());
        int needLength = Integer.parseInt(tokenizer.nextToken());

        List<Integer> trees = new ArrayList<>();
        tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) trees.add(Integer.parseInt(tokenizer.nextToken()));
        trees.sort(Comparator.comparingInt(o -> o));

        int max = trees.get(trees.size() - 1);
        int min = 0;

        while (min < max) {
            int mid = (max + min) / 2;
            long sum = 0;
            for (Integer tree : trees) sum += tree > mid ? tree - mid : 0;
            if (sum < needLength) max = mid;
            else min = mid + 1;
        }

        result.append(min - 1);
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