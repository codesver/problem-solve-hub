import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int startX = Integer.parseInt(tokenizer.nextToken());
        int endX = Integer.parseInt(tokenizer.nextToken());
        int[] times = new int[100001];

        Queue<Integer> queue = new LinkedList<>(Collections.singleton(startX));
        while (!queue.isEmpty()) {
            Integer location = queue.poll();
            if (location == endX) {
                result.append(times[location]);
                break;
            }
            if (location - 1 >= 0 && times[location - 1] == 0) {
                times[location - 1] = times[location] + 1;
                queue.add(location - 1);
            }
            if (location + 1 <= 100000 && times[location + 1] == 0) {
                times[location + 1] = times[location] + 1;
                queue.add(location + 1);
            }
            if (location * 2 <= 100000 && times[location * 2] == 0) {
                times[location * 2] = times[location] + 1;
                queue.add(location * 2);
            }
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