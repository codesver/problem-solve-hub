import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int commands = Integer.parseInt(reader.readLine());
        Queue<Integer> xes = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1) == Math.abs(o2) ?
                        o1 - o2 :
                        Math.abs(o1) - Math.abs(o2));
        while (commands-- > 0) {
            int x = Integer.parseInt(reader.readLine());
            if (x == 0) result.append(xes.isEmpty() ? 0 : xes.poll()).append("\n");
            else xes.add(x);
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