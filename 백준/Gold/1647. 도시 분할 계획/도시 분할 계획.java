import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class Road implements Comparable<Road> {

    int homeA, homeB, cost;

    public Road(int homeA, int homeB, int cost) {
        this.homeA = homeA;
        this.homeB = homeB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road road) {
        return cost - road.cost;
    }
}

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private int[] roots;
    private final Queue<Road> roads = new PriorityQueue<>();

    public void solve() throws IOException {
        init();
        int weight = divideCity();
        result.append(weight);
    }

    private void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int homeNum = Integer.parseInt(tokenizer.nextToken());
        int roadNum = Integer.parseInt(tokenizer.nextToken());

        roots = IntStream.rangeClosed(0, homeNum).toArray();
        while (roadNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int homeA = Integer.parseInt(tokenizer.nextToken());
            int homeB = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());
            roads.offer(new Road(homeA, homeB, cost));
        }
    }

    private int divideCity() {
        int weight = 0, count = 0;
        while (!roads.isEmpty() && count != roots.length - 3) {
            Road road = roads.poll();
            int rootA = find(road.homeA);
            int rootB = find(road.homeB);
            if (rootA != rootB) {
                weight += road.cost;
                count++;
                union(rootA, rootB);
            }
        }
        return weight;
    }

    private void union(int homeA, int homeB) {
        if (homeA < homeB) roots[homeB] = homeA;
        else roots[homeA] = homeB;
    }

    private int find(int road) {
        return road == roots[road] ? road : find(roots[road]);
    }

    private void finish() throws IOException {
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