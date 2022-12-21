import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer;
        int MX, MY, TX, TY;
        while (T-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            MX = Integer.parseInt(tokenizer.nextToken());
            MY = Integer.parseInt(tokenizer.nextToken());
            TX = Integer.parseInt(tokenizer.nextToken());
            TY = Integer.parseInt(tokenizer.nextToken());
            
            if (TY == MY) TY = 0;
            int YEAR = 0;
            while (true) {
                if ((MX * YEAR + TX) % MY == TY) {
                    result.append(MX * YEAR + TX).append("\n");
                    break;
                }
                if (MX * YEAR + TX > MX * MY) {
                    result.append(-1).append("\n");
                    break;
                }
                YEAR++;
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