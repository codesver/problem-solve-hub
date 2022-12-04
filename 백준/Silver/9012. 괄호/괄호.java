import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int test = Integer.parseInt(reader.readLine());
        while (test-- > 0) {
            int count = 0;
            String[] brackets = reader.readLine().split("");
            for (String bracket : brackets)
                if (bracket.equals("(")) count++;
                else if (count-- == 0) break;
            result.append(count == 0 ? "YES" : "NO").append("\n");
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