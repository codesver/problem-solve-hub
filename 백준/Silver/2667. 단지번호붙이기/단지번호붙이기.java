import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][] apartment;

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        apartment = new int[size + 2][size + 2];
        
        initApartment(size);
        Queue<Integer> queue = searchNeighbors(size);
        showComplexes(queue);
    }

    private static void initApartment(int size) throws IOException {
        for (int i = 1; i < size + 1; i++)
            apartment[i] = ("0" + reader.readLine() + "0").chars().map(Character::getNumericValue).toArray();
    }

    private static Queue<Integer> searchNeighbors(int size) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= size + 1; i++)
            for (int j = 1; j <= size + 1; j++)
                if (apartment[i][j] == 1) queue.add(search(i, j));
        return queue;
    }

    private static int search(int i, int j) {
        Queue<Home> homes = new LinkedList<>();
        homes.add(new Home(i, j));
        int count = 0;
        while (!homes.isEmpty()) {
            Home home = homes.poll();
            if (apartment[home.i][home.j] == 1) {
                count++;
                apartment[home.i][home.j] = 0;
                homes.add(new Home(home.i - 1, home.j));
                homes.add(new Home(home.i, home.j + 1));
                homes.add(new Home(home.i + 1, home.j));
                homes.add(new Home(home.i, home.j - 1));
            }
        }
        return count;
    }

    private static void showComplexes(Queue<Integer> queue) {
        result.append(queue.size()).append("\n");
        while (!queue.isEmpty()) result.append(queue.poll()).append("\n");
    }

    static class Home {
        int i, j;

        public Home(int i, int j) {
            this.i = i;
            this.j = j;
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