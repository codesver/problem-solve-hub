import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(("0 " + reader.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] palindrome = new int[N + 1][N + 1];

        StringTokenizer tokenizer;
        int Q = Integer.parseInt(reader.readLine());
        while (Q-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int s = Integer.parseInt(tokenizer.nextToken());
            int e = Integer.parseInt(tokenizer.nextToken());
            if (palindrome[s][e] == 0) {
                if (palindrome(nums, s, e)) {
                    result.append(1).append("\n");
                    while (s <= e) {
                        palindrome[s][e] = 1;
                        s++;
                        e--;
                    }
                } else {
                    result.append(0).append("\n");
                    palindrome[s][e] = 2;
                }
            } else result.append(palindrome[s][e] == 1 ? 1 : 0).append("\n");
        }
    }

    public boolean palindrome(int[] nums, int s, int e) {
        while (s < e) {
            if (nums[s] != nums[e]) return false;
            s++;
            e--;
        }
        return true;
    }

    private void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}