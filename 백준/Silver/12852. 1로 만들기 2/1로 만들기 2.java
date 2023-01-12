import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[] counts;
    private static int[] parents;

    private static void solution() throws IOException {
        final int NUM = Integer.parseInt(reader.readLine());
        counts = new int[NUM + 1];
        parents = new int[NUM + 1];

        for (int num = NUM - 1; num >= 1; num--) {
            if (num * 3 <= NUM) ignition(num, num * 3, num * 2, num + 1);
            else if (num * 2 <= NUM) ignition(num, num * 2, num + 1);
            else ignition(num, num + 1);
        }

        int num = 1;
        Stack<Integer> nums = new Stack<>();
        while (num != 0) {
            nums.push(num);
            num = parents[num];
        }
        result.append(counts[1]).append("\n");
        while (!nums.isEmpty()) result.append(nums.pop()).append(" ");
    }

    private static void ignition(int child, int... nums) {
        int minCount = Integer.MAX_VALUE;
        int parent = 0;
        for (int num : nums) {
            if (minCount > counts[num]) {
                minCount = counts[num];
                parent = num;
            }
        }
        parents[child] = parent;
        counts[child] = counts[parent] + 1;
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