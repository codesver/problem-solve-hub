import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int M = Integer.parseInt(reader.readLine());
        int N = Integer.parseInt(reader.readLine());
        int sum = 0;
        int min = N;
        x : for (int i = M; i <= N; i++) {
            if (i == 1) continue;
            for (int j = 2; j < i; j++)
                if (i % j == 0) continue x;
            sum += i;
            if (min > i) min = i;
        }
        if (sum == 0 ) {
            result.append(-1).append("\n");
            return;
        }
        result.append(sum).append("\n").append(min);
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