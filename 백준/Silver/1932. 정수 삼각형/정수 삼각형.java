import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    static class Solution {

        private static void solve() throws IOException {
            List<List<Integer>> layers = new ArrayList<>();
            int size = Integer.parseInt(reader.readLine());
            if (size == 1) result.append(Integer.parseInt(reader.readLine()));
            else {
                while (size-- > 0) layers.add(Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).boxed()
                        .collect(Collectors.toList()));
                int max = Integer.MIN_VALUE;
                for (int depth = 1; depth < layers.size(); depth++) {
                    List<Integer> uppers = layers.get(depth - 1);
                    List<Integer> lowers = layers.get(depth);

                    for (int l = 0; l < lowers.size(); l++) {
                        int value = lowers.get(l);
                        if (l == 0) value += uppers.get(l);
                        else if (l == lowers.size() - 1) value += uppers.get(l - 1);
                        else value += Math.max(uppers.get(l - 1), uppers.get(l));
                        lowers.set(l, value);
                        max = Math.max(max, value);
                    }
                }
                result.append(max);
            }
        }
    }

    private static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Solution.solve();
        finish();
    }
}