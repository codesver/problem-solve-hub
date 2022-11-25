import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (max < num) {
                max = num;
                index = i;
            }
        }

        result.append(max).append("\n").append(index);
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

