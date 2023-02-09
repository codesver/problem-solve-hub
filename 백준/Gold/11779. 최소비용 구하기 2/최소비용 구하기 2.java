import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    public static final int MAX = 100_000_000;

    public static void solution() throws IOException {
        Map<Integer, City> country = IntStream.rangeClosed(1, Integer.parseInt(reader.readLine()))
                .mapToObj(City::new)
                .collect(Collectors.toMap(city -> city.number, city -> city));

        StringTokenizer tokenizer;
        int B = Integer.parseInt(reader.readLine());
        while (B-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            City from = country.get(Integer.parseInt(tokenizer.nextToken()));
            City to = country.get(Integer.parseInt(tokenizer.nextToken()));
            from.updateBus(to, Integer.parseInt(tokenizer.nextToken()));
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int S = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());
        country.get(S).setToStart();
        country.get(E).end = true;

        Queue<City> cities = new PriorityQueue<>(Collections.singleton(country.get(S)));
        while (!cities.isEmpty()) {
            City city = cities.poll();
            if (city.visited) continue;
            if (city.end) {
                result.append(city);
                break;
            }
            city.next(cities);
        }
    }

    static class City implements Comparable<City> {

        int number, cost = MAX;
        boolean visited = false, end = false;
        final Map<City, Integer> buses = new HashMap<>();
        final List<Integer> path = new ArrayList<>();

        public City(int number) {
            this.number = number;
        }

        public void updateBus(City to, int cost) {
            buses.put(to, Math.min(buses.getOrDefault(to, MAX), cost));
        }

        public void updatePath(List<Integer> path) {
            this.path.clear();
            this.path.addAll(path);
            this.path.add(number);
        }

        public void next(Queue<City> cities) {
            visited = true;
            for (Map.Entry<City, Integer> bus : buses.entrySet()) {
                City city = bus.getKey();
                Integer cost = bus.getValue();
                if (!city.visited && city.cost > this.cost + cost) {
                    city.cost = this.cost + cost;
                    city.updatePath(path);
                    cities.offer(city);
                }
            }
        }

        public void setToStart() {
            cost = 0;
            path.add(number);
        }

        @Override
        public int compareTo(City o) {
            return cost == o.cost ? number - o.number : cost - o.cost;
        }

        @Override
        public String toString() {
            return cost + "\n" + path.size() + "\n" + path.stream().map(String::valueOf).collect(Collectors.joining(" "));
        }
    }

    public static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}