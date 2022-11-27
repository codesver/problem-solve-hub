import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(tokenizer.nextToken());
        int col = Integer.parseInt(tokenizer.nextToken());

        List<StringTokenizer> list = new ArrayList<>();
        for (int r = 0; r < row * 2; r++)
            if (r < row) list.add(new StringTokenizer(reader.readLine()));
            else {
                StringTokenizer tokA = list.get(r - row);
                StringTokenizer tokB = new StringTokenizer(reader.readLine());

                while (tokA.hasMoreTokens())
                    result.append(Integer.parseInt(tokA.nextToken()) + Integer.parseInt(tokB.nextToken()))
                            .append(" ");
                result.append("\n");
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