import java.io.*;
import java.math.BigInteger;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        final int LENGTH = Integer.parseInt(reader.readLine());
        final String LINE = reader.readLine();
        final int M = 1234567891;

        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < LENGTH; i++)
            sum = sum.add(BigInteger.valueOf(LINE.charAt(i) - 96)
                    .multiply(BigInteger.valueOf(31).pow(i)));
        result.append(sum.remainder(BigInteger.valueOf(1234567891)));
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