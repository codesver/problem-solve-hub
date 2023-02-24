import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        String nums;
        StringTokenizer tokenizer;
        while (!(nums = reader.readLine()).equals("0 0")) {
            tokenizer = new StringTokenizer(nums);
            int numA = Integer.parseInt(tokenizer.nextToken());
            int numB = Integer.parseInt(tokenizer.nextToken());
            if (numA < numB && numB % numA == 0) result.append("factor");
            else if (numA > numB && numA % numB == 0) result.append("multiple");
            else result.append("neither");
            result.append("\n");
        }
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