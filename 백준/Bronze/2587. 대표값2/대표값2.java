import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        List<Integer> list = new ArrayList<>();
        int repeat = 5;
        int sum = 0;
        while (repeat-- > 0) {
            int num = Integer.parseInt(reader.readLine());
            list.add(num);
            sum += num;
        }
        list.sort(Comparator.comparingInt(o -> o));
        result.append(sum / 5).append("\n").append(list.get(2));
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