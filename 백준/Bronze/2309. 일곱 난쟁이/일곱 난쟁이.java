import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int[] heights = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(reader.readLine());
            heights[i] = height;
            sum += height;
        }

        int others = sum - 100;
        Loop:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == others) {
                    heights[i] = 0;
                    heights[j] = 0;
                    Arrays.sort(heights);
                    break Loop;
                }
            }
        }

        for (int k = 2; k < heights.length; k++)
            result.append(heights[k]).append("\n");
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