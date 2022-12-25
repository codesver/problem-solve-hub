import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int FLOOR = Integer.parseInt(reader.readLine());
            int ROOM = Integer.parseInt(reader.readLine());

            int[][] apartment = new int[FLOOR + 1][ROOM + 1];
            for (int f = 0; f <= FLOOR; f++)
                for (int r = 1; r <= ROOM; r++)
                    if (f == 0) apartment[f][r] = r;
                    else if (r == 1) apartment[f][r] = 1;
                    else apartment[f][r] = apartment[f - 1][r] + apartment[f][r - 1];

            result.append(apartment[FLOOR][ROOM]).append("\n");
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