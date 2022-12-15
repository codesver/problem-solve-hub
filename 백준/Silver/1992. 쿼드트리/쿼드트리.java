import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][] image;

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        image = new int[size][size];
        for (int i = 0; i < size; i++)
            image[i] = reader.readLine().chars().map(Character::getNumericValue).toArray();
        compress(size, 0, 0);
    }

    private static void compress(int size, int startI, int startJ) {
        int pixel = image[startI][startJ];
        compressor:
        for (int pi = startI; pi < startI + size; pi++)
            for (int pj = startJ; pj < startJ + size; pj++)
                if (image[pi][pj] != pixel) {
                    result.append("(");
                    for (int si = startI; si < startI + size; si += size / 2)
                        for (int sj = startJ; sj < startJ + size; sj += size / 2)
                            compress(size / 2, si, sj);
                    result.append(")");
                    break compressor;
                } else if (pi == startI + size - 1 && pj == startJ + size - 1) 
                    result.append(pixel);
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