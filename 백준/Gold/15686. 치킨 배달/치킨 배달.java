import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static final List<Loc> homes = new ArrayList<>();
    private static final List<Loc> stores = new ArrayList<>();
    private static final Deque<Loc> choices = new LinkedList<>();

    private static int SIZE;
    private static int MAX_STORE;
    private static int minDistance = Integer.MAX_VALUE;

    private static StringTokenizer tokenizer;

    private static void solution() throws IOException {
        init();
        search(0);
        result.append(minDistance);
    }

    private static void init() throws IOException {
        readConstant();
        readMap();
    }

    private static void readConstant() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        SIZE = Integer.parseInt(tokenizer.nextToken());
        MAX_STORE = Integer.parseInt(tokenizer.nextToken());
    }

    private static void readMap() throws IOException {
        for (int i = 0; i < SIZE; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < SIZE; j++) {
                int type = Integer.parseInt(tokenizer.nextToken());
                if (type == 1) homes.add(new Loc(i, j));
                else if (type == 2) stores.add(new Loc(i, j));
            }
        }
    }

    private static void search(int idx) {
        for (; idx < stores.size(); idx++) {
            choices.addLast(stores.get(idx));
            choose(idx + 1);
            choices.pollLast();
        }
    }

    private static void choose(int idx) {
        if (choices.size() == MAX_STORE) {
            int distance = 0;
            for (Loc home : homes) {
                int min = Integer.MAX_VALUE;
                for (Loc choice : choices) min = Math.min(min, home.distance(choice));
                distance += min;
            }
            minDistance = Math.min(minDistance, distance);
        } else search(idx);
    }

    static class Loc {
        
        int i, j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int distance(Loc loc) {
            return Math.abs(i - loc.i) + Math.abs(j - loc.j);
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