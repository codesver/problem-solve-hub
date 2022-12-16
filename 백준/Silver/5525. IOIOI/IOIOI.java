import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        int length = Integer.parseInt(reader.readLine());
        char[] ioi = reader.readLine().toCharArray();
        int[] memo = new int[length];
        int count = 0;

        for (int i = 1; i < length - 1; i++)
            if (ioi[i] == 'O' && ioi[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;
                if (memo[i + 1] >= size && ioi[i - 2 * size + 1] == 'I')
                    count++;
            }

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