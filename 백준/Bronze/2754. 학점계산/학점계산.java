import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        String grade = reader.readLine();
        if (grade.equals("F")) result.append(0.0);
        else result.append((double) (69 - grade.charAt(0))
                + (grade.charAt(1) == '0' ? 0 : grade.charAt(1) == '+' ? 0.3 : -0.3));
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