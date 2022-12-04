import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int cardNum = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        List<Integer> numbers = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) numbers.add(Integer.parseInt(tokenizer.nextToken()));

        int max = Integer.MIN_VALUE;
        FirstLoop: for (int i = 0; i < numbers.size() - 2; i++) {
            Integer firstNumber = numbers.get(i);
            if (firstNumber >= M - 1) continue;
            for (int j = i + 1; j < numbers.size() - 1; j++) {
                Integer secondNumber = numbers.get(j);
                if (firstNumber + secondNumber >= M) continue;
                for (int k = j + 1; k < numbers.size(); k++) {
                    Integer thirdNumber = numbers.get(k);
                    int sum = firstNumber + secondNumber + thirdNumber;
                    if (sum < M) max = Math.max(max, sum);
                    else if (sum == M) {
                        max = M;
                        break FirstLoop;
                    }
                }
            }
        }
        result.append(max);
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