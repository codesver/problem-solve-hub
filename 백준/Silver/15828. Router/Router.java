import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Queue<Integer> router = new LinkedList<>();
        int size = Integer.parseInt(reader.readLine());
        int packet;
        while ((packet = Integer.parseInt(reader.readLine())) != -1)
            if (packet == 0) router.poll();
            else if (router.size() != size) router.add(packet);
        if (router.isEmpty()) result.append("empty");
        else while (!router.isEmpty()) result.append(router.poll()).append(" ");
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