import java.io.*;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        result.append("     /~\\\n" +
                "    ( oo|\n" +
                "    _\\=/_\n" +
                "   /  _  \\\n" +
                "  //|/.\\|\\\\\n" +
                " ||  \\ /  ||\n" +
                "============\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |");
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