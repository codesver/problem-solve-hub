import java.io.*;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        String string = reader.readLine();
        String front = string.substring(0, string.length() / 2);
        String back = string.substring(string.length() / 2 + (string.length() % 2 == 0 ? 0 : 1));
        result.append(front.equals(new StringBuilder(back).reverse().toString()) ? 1 : 0);
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