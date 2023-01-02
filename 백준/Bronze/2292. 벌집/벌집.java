import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int TARGET = Integer.parseInt(reader.readLine());
        int floor = 0;
        int cell = 2;
        if (TARGET == 1) result.append(1);
        else while (++floor > 0) {
            if (cell <= TARGET && TARGET <= cell + 6 * floor - 1) {
                result.append(floor + 1);
                break;
            } else cell += 6 * (floor);
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