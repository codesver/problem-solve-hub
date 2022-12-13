import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int count = 0;

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int size = (int) Math.pow(2, Integer.parseInt(tokenizer.nextToken()));
        search(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()), size);
        result.append(count);
    }

    private static void search(int row, int col, int size) {
        int boundary = size / 2;
        if (boundary != 0) {
            if (row < boundary && col < boundary) {
                search(row, col, boundary);
            } else if (row < boundary) {
                count += Math.pow(boundary, 2);
                search(row, col - boundary, boundary);
            } else if (col < boundary) {
                count += Math.pow(boundary, 2) * 2;
                search(row - boundary, col, boundary);
            } else {
                count += Math.pow(boundary, 2) * 3;
                search(row - boundary, col - boundary, boundary);
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