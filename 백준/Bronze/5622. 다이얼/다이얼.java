import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        result.append(reader.readLine().chars()
                .map(ch -> ch < 83 ? 
                        ch % 65 / 3 + 3 : 
                        ch != 90 ? 
                                ch % 81 / 3 + 8 : 
                                10)
                .sum());
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