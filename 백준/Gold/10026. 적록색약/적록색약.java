import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int countRBG = 0, countYB = 0;
    private static final char WHITE = '\u0000';

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        char[][] pictureRGB = new char[N + 2][N + 2];
        char[][] pictureYB = new char[N + 2][N + 2];

        for (int r = 1; r <= N; r++) {
            char[] colors = reader.readLine().toCharArray();
            for (int c = 1; c <= N; c++) {
                pictureRGB[r][c] = colors[c - 1];
                pictureYB[r][c] = colors[c - 1] == 'B' ? 'B' : 'Y';
            }
        }

        for (int r = 1; r <= N; r++)
            for (int c = 1; c <= N; c++) {
                if (pictureRGB[r][c] != WHITE) {
                    countRBG++;
                    search(pictureRGB, r, c);
                }
                if (pictureYB[r][c] != WHITE) {
                    countYB++;
                    search(pictureYB, r, c);
                }
            }

        result.append(countRBG).append(" ").append(countYB);
    }

    private static void search(char[][] picture, int row, int col) {
        char color = picture[row][col];
        picture[row][col] = WHITE;
        if (picture[row - 1][col] == color) search(picture, row - 1, col);
        if (picture[row][col + 1] == color) search(picture, row, col + 1);
        if (picture[row + 1][col] == color) search(picture, row + 1, col);
        if (picture[row][col - 1] == color) search(picture, row, col - 1);
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