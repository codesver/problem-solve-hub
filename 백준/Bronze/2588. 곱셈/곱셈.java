import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int num1 = Integer.parseInt(reader.readLine());
        String num2 = reader.readLine();
        result.append(num1 * Character.getNumericValue(num2.charAt(2))).append("\n")
                .append(num1 * Character.getNumericValue(num2.charAt(1))).append("\n")
                .append(num1 * Character.getNumericValue(num2.charAt(0))).append("\n")
                .append(num1 * Integer.parseInt(num2));
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
