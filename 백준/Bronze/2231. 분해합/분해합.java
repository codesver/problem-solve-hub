import java.io.*;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        String numberStr = reader.readLine();
        int number = Integer.parseInt(numberStr);
        result.append(0);
        for (int num = 1; num < number; num++) {
            int splitSum = num + Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).sum();
            if (splitSum == number) {
                result.deleteCharAt(0).append(num);
                break;
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