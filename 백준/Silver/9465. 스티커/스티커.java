import java.io.*;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();


    private static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int L = Integer.parseInt(reader.readLine());
            int[][] scores = new int[2][L];

            scores[0] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            scores[1] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (L == 1) result.append(Math.max(scores[0][0], scores[1][0])).append("\n");
            else {
                scores[0][1] += scores[1][0];
                scores[1][1] += scores[0][0];

                for (int i = 2; i < L; i++) {
                    scores[0][i] += Math.max(scores[1][i - 1], scores[1][i - 2]);
                    scores[1][i] += Math.max(scores[0][i - 1], scores[0][i - 2]);
                }

                result.append(Math.max(scores[0][L - 1], scores[1][L - 1])).append("\n");
            }
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