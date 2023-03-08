import java.io.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        String strI = reader.readLine();
        String strJ = reader.readLine();

        int[][] lcs = new int[strI.length() + 1][strJ.length() + 1];

        for (int i = 1; i <= strI.length(); i++)
            for (int j = 1; j <= strJ.length(); j++)
                lcs[i][j] = strI.charAt(i - 1) == strJ.charAt(j - 1) ?
                        lcs[i - 1][j - 1] + 1 :
                        Math.max(lcs[i - 1][j], lcs[i][j - 1]);

        StringBuilder builder = new StringBuilder();
        int i = strI.length(), j = strJ.length();
        while (lcs[i][j] != 0) {
            if (lcs[i][j] == lcs[i - 1][j]) i--;
            else if (lcs[i][j] == lcs[i][j - 1]) j--;
            else {
                builder.append(strI.charAt(--i));
                j--;
            }
        }

        result.append(builder.length());
        if (builder.length() != 0) result.append("\n").append(builder.reverse());
    }

    private void finish() throws IOException {
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