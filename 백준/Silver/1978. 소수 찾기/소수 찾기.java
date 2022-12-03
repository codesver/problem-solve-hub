import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        List<Integer> nums = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(tokenizer.nextToken());
            max = Math.max(max, num);
            nums.add(num);
        }

        boolean[] isNotPrime = new boolean[max + 1];
        isNotPrime[1] = true;
        for (int i = 2; i < isNotPrime.length; i++)
            if (!isNotPrime[i])
                for (int j = i * 2; j < isNotPrime.length; j += i)
                    isNotPrime[j] = true;

        int count = 0;
        for (Integer num : nums) count += isNotPrime[num] ? 0 : 1;

        result.append(count);
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