import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int[] counter = new int[10000];
        int repeat = Integer.parseInt(reader.readLine());
        while (repeat-- > 0) {
            int num = Integer.parseInt(reader.readLine());
            counter[num - 1]++;
        }
        for (int i = 0; i < counter.length; i++) {
            int count = counter[i];
            result.append(((i + 1) + "\n").repeat(count));
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