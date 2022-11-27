import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        boolean[][] paper = new boolean[100][100];

        int repeat = Integer.parseInt(reader.readLine());
        while (repeat-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int startX = Integer.parseInt(tokenizer.nextToken());
            int startY = Integer.parseInt(tokenizer.nextToken());
            for (int x = startX; x < Math.min(startX + 10, 100); x++) 
                Arrays.fill(paper[x], startY, Math.min(startY + 10, 100), true);
        }

        int count = 0;
        for (boolean[] pap : paper) for (boolean p : pap) count += p ? 1 : 0;
        result.append(count);
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