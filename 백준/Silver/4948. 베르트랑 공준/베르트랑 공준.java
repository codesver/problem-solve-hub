import java.io.*;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        final int MAX = 246913;
        boolean[] prime = new boolean[MAX];
        Arrays.fill(prime, true);
        prime[1] = false;
        for (int i = 2; i < MAX; i++)
            if (prime[i])
                for (int j = i * 2; j < MAX; j += i)
                    prime[j] = false;

        int n;
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            int count = 0;
            for (int i = n + 1; i <= n * 2; i++)
                if (prime[i]) count++;
            result.append(count).append("\n");
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