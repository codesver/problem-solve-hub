import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int repeat = Integer.parseInt(reader.readLine());

        int sum = 0;
        List<Integer> memory = new ArrayList<>();
        List<Integer> counter = new ArrayList<>(Collections.nCopies(8001, 0));

        while (repeat-- > 0) {
            int num = Integer.parseInt(reader.readLine());
            sum += num;
            memory.add(num);
            counter.set(num + 4000, counter.get(num + 4000) + 1);
        }

        memory.sort(Comparator.comparingInt(o -> o));
        Integer max = counter.stream().max(Comparator.comparingInt(o -> o)).get();
        int most = counter.indexOf(max) - 4000;
        for (int i = counter.indexOf(max) + 1; i < counter.size(); i++) {
            Integer value = counter.get(i);
            if (value.equals(max)) {
                most = i - 4000;
                break;
            }
        }

        result.append(Math.round(sum / (double) memory.size())).append("\n")
                .append(memory.get(memory.size() / 2)).append("\n")
                .append(most).append("\n")
                .append(memory.get(memory.size() - 1) - memory.get(0));

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