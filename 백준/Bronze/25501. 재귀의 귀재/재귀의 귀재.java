import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int count = 0;

    private static void solution() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            count = 0;
            result.append(isPalindrome(reader.readLine()))
                    .append(" ")
                    .append(count)
                    .append("\n");
        }
    }

    private static int isPalindrome(String string) {
        return recursion(string, 0, string.length() - 1);
    }

    private static int recursion(String string, int left, int right) {
        count++;
        if (left >= right) return 1;
        else if (string.charAt(left) != string.charAt(right)) return 0;
        else return recursion(string, left + 1, right - 1);
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