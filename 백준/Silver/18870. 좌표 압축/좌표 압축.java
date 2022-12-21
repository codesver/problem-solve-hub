import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (N-- > 0) {
            int coordinate = Integer.parseInt(tokenizer.nextToken());
            set.add(coordinate);
            list.add(coordinate);
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer coordinate : set) map.put(coordinate, count++);
        for (Integer coordinate : list) result.append(map.get(coordinate)).append(" ");
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