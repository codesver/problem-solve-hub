import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int computerNum = Integer.parseInt(reader.readLine());
        int networkNum = Integer.parseInt(reader.readLine());
        boolean[][] network = new boolean[computerNum + 1][computerNum + 1];
        while (networkNum-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int computerA = Integer.parseInt(tokenizer.nextToken());
            int computerB = Integer.parseInt(tokenizer.nextToken());
            network[computerA][computerB] = network[computerB][computerA] = true;
        }

        boolean[] infected = new boolean[computerNum + 1];
        infected[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int count = 0;

        while (!queue.isEmpty()) {
            Integer computer = queue.poll();
            for (int cpu = 2; cpu <= computerNum; cpu++) {
                if (network[computer][cpu] && !infected[cpu]) {
                    queue.add(cpu);
                    infected[cpu] = true;
                    count++;
                }
            }
        }

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