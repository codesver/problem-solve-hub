import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int n = Integer.parseInt(reader.readLine());

        int[] memory = new int[21];
        memory[0] = 0;
        memory[1] = 1;

        if (n == 0 || n == 1) {
            result.append(memory[n]);
        } else {
            for (int i = 2; i <= n; i++) memory[i] = memory[i - 1] + memory[i - 2];
            result.append(memory[n]);
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