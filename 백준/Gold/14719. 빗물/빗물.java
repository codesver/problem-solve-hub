import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int H = Integer.parseInt(tokenizer.nextToken());
        int W = Integer.parseInt(tokenizer.nextToken());
        int[] heights = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int water = 0;
        while (H > 0) {
            for (int i = 0; i < W; i++) {
                if (heights[i] >= H) {
                    for (int j = i + 1; j < W; j++) {
                        if (heights[j] >= H) {
                            water += j - i - 1;
                            i = j - 1;
                            break;
                        }
                    }
                }
            }
            H--;
        }
        result.append(water);
    }

    public void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}