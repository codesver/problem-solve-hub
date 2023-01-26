import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Queue<Integer> packs = new PriorityQueue<>();
        int C = Integer.parseInt(reader.readLine());
        while (C-- > 0) packs.add(Integer.parseInt(reader.readLine()));
        int merge = 0;
        while (!packs.isEmpty()) {
            Integer pack = packs.poll();
            if (!packs.isEmpty()) {
                int sum = pack + packs.poll();
                merge += sum;
                packs.add(sum);
            } else result.append(merge);
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