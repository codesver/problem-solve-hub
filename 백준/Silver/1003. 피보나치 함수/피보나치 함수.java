import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[] zeroCounter = new int[41];
    private static int[] oneCounter = new int[41];
    private static boolean[] counted = new boolean[41];

    private static void solution() throws IOException {
        int test = Integer.parseInt(reader.readLine());
        zeroCounter[0] = 1;
        oneCounter[1] = 1;
        counted[0] = counted[1] = true;

        while (test-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            if (!counted[N]) fibonacci(N);
            result.append(zeroCounter[N]).append(" ").append(oneCounter[N]).append("\n");
        }
    }

    private static void fibonacci(int num) {
        for (int i = 2; i <= num; i++) {
            zeroCounter[i] = zeroCounter[i - 1] + zeroCounter[i - 2];
            oneCounter[i] = oneCounter[i - 1] + oneCounter[i - 2];
            counted[i] = true;
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