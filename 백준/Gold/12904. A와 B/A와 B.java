import java.io.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        String initString = reader.readLine();
        String finString = reader.readLine();
        result.append(canConvert(initString, finString) ? 1 : 0);
    }

    private boolean canConvert(String initString, String finString) {
        StringBuilder fin = new StringBuilder(finString);
        while (fin.length() > initString.length())
            if (fin.charAt(fin.length() - 1) == 'A') fin.deleteCharAt(fin.length() - 1);
            else fin.deleteCharAt(fin.length() - 1).reverse();
        return fin.toString().equals(initString);
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