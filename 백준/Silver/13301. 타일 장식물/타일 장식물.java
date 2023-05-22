import java.io.*;
import java.math.BigInteger;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        BigInteger[] nums = new BigInteger[n + 1];
        nums[0] = BigInteger.ZERO;
        nums[1] = BigInteger.ONE;
        for(int i = 2; i <= n; i++) nums[i] = nums[i - 1].add(nums[i - 2]);
        result.append(nums[n].shiftLeft(1).add(nums[n - 1]).shiftLeft(1));
    }

    public void finish() throws IOException {
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