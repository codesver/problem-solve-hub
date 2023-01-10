import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        char[] A = reader.readLine().toCharArray();
        char[] B = reader.readLine().toCharArray();

        int[][] lcs = new int[A.length + 1][B.length + 1];
        for (int a = 1; a <= A.length; a++)
            for (int b = 1; b <= B.length; b++)
                lcs[a][b] = A[a - 1] == B[b - 1] ? lcs[a - 1][b - 1] + 1 : Math.max(lcs[a - 1][b], lcs[a][b - 1]);

        result.append(lcs[A.length][B.length]);
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