import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    static class Client {
        int id, time, arriveTime;

        public Client(int id, int time, int arriveTime) {
            this.id = id;
            this.time = time;
            this.arriveTime = arriveTime;
        }
    }
    
    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int T = Integer.parseInt(tokenizer.nextToken());
        int W = Integer.parseInt(tokenizer.nextToken());

        Queue<Client> line = new LinkedList<>();

        while (N-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int id = Integer.parseInt(tokenizer.nextToken());
            int time = Integer.parseInt(tokenizer.nextToken());
            line.offer(new Client(id, time, 0));
        }

        int M = Integer.parseInt(reader.readLine());
        Queue<Client> waiting = new PriorityQueue<>(Comparator.comparingInt(o -> o.arriveTime));

        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int id = Integer.parseInt(tokenizer.nextToken());
            int time = Integer.parseInt(tokenizer.nextToken());
            int arriveTime = Integer.parseInt(tokenizer.nextToken());
            waiting.offer(new Client(id, time, arriveTime));
        }

        List<Integer> ids = new ArrayList<>();
        int time = 0;
        while (!line.isEmpty()) {
            Client client = line.poll();
            if (client.time <= T) {
                time += client.time;
                while (client.time-- > 0) ids.add(client.id);
            } else {
                IntStream.range(0, T).forEach(i -> ids.add(client.id));
                client.time -= T;
                time += T;
            }
            while (!waiting.isEmpty() && waiting.peek().arriveTime <= time) line.offer(waiting.poll());
            if (client.time > 0) line.offer(client);
        }

        ids.subList(0, W).forEach(id -> result.append(id).append('\n'));
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