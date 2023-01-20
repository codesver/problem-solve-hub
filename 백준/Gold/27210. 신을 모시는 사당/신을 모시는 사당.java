import java.io.*;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[] dirs = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        
        int maxLeft = 0, maxRight = 0;
        int sumLeft = 0, sumRight = 0;

        for (int dir : dirs) {
            if (dir == 1) {
                sumLeft = Math.max(sumLeft + 1, 1);
                maxLeft = Math.max(maxLeft, sumLeft);
                sumRight--;
            } else {
                sumRight = Math.max(sumRight + 1, 1);
                maxRight = Math.max(maxRight, sumRight);
                sumLeft--;
            }
        }
        result.append(Math.max(maxLeft, maxRight));
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