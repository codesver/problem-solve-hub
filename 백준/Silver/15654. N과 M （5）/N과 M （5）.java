import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int N, M;
    private static final List<Integer> nums = new ArrayList<>();
    private static final List<Boolean> visited = new ArrayList<>();

    private static void solution() throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) {
            nums.add(Integer.parseInt(tokenizer.nextToken()));
            visited.add(false);
        }
        nums.sort(Comparator.comparingInt(o -> o));
    }

    private static void solve() {
        IntStream.range(0, N).forEach(idx -> {
            visited.set(idx, true);
            search(nums.get(idx));
            visited.set(idx, false);
        });
        result.delete(result.length() - 1, result.length());
    }

    private static void search(int... found) {
        if (found.length == M) {
            Arrays.stream(found).forEach(num -> result.append(num).append(" "));
            result.delete(result.length() - 1, result.length());
            result.append("\n");
        } else {
            IntStream.range(0, N).forEach(idx -> {
                if (!visited.get(idx)) {
                    visited.set(idx, true);
                    int[] copied = Arrays.copyOf(found, found.length + 1);
                    copied[copied.length - 1] = nums.get(idx);
                    search(copied);
                    visited.set(idx, false);
                }
            });
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