import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[] counter = new int[N + 1];
        counter[0] = counter[1] = 1;
        for (int l = 2; l <= N; l++) counter[l] = (counter[l - 1] + counter[l - 2]) % 10007;
        result.append(counter[N]);
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