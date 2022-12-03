import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int repeat = 3;
        int num = 1;
        while (repeat-- > 0) num *= Integer.parseInt(reader.readLine());
        int[] counts = new int[10];
        while (num != 0) {
            counts[num % 10]++;
            num /= 10;
        }
        for (int count : counts) result.append(count).append("\n");
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