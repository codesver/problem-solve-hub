import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    static class Solution {

        private static void solve() throws IOException {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long A = Long.parseLong(tokenizer.nextToken());
            long B = Long.parseLong(tokenizer.nextToken());
            long C = Long.parseLong(tokenizer.nextToken());
            result.append(calculate(A, B, C) % C);
        }

        private static long calculate(long a, long b, long c) {
            if (b == 0) return 1;
            else if (b == 1) return a;
            else if (b % 2 == 0) { //짝수 지수
                long n = calculate(a, b / 2, c) % c;
                return (n * n) % c;
            } else { //홀수 지수
                long n = calculate(a, b / 2, c) % c;
                return (((n * n) % c) * a) % c;
            }
        }
    }

    private static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Solution.solve();
        finish();
    }
}