import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        int[] counter = new int[8001];

        double sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(reader.readLine());
            sum += num;
            counter[num + 4000]++;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int midCounter = 0, midValue = 0;
        int maxCount = 0, maxCountValue = 0;
        boolean isSecond = false;
        for (int i = min + 4000; i <= max + 4000; i++) {
            if (counter[i] <= 0) continue;

            if (midCounter < size / 2 + 1) {
                midCounter += counter[i];
                midValue = i - 4000;
            }

            if (counter[i] > maxCount) {
                maxCount = counter[i];
                maxCountValue = i - 4000;
                isSecond = true;
            } else if (counter[i] == maxCount && isSecond) {
                maxCountValue = i - 4000;
                isSecond = false;
            }
        }

        result.append(Math.round(sum / size)).append("\n")
                .append(midValue).append("\n")
                .append(maxCountValue).append("\n")
                .append(max - min).append("\n");
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