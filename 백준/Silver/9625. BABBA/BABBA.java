import java.io.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int num = Integer.parseInt(reader.readLine());
        int[][] chars = new int[num + 1][2];
        chars[0][0] = 1;
        for(int i = 1; i < chars.length; i++) chars[i][1] = chars[i - 1][0] + (chars[i][0] = chars[i - 1][1]);
        result.append(chars[num][0]).append(' ').append(chars[num][1]);
    }

    public void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}