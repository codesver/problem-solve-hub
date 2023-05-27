import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        Stack<Integer> jumpers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(Stack::new));
        List<Integer> steps = new ArrayList<>();
        while (!jumpers.isEmpty()) {
            try {
                steps.add(steps.get(steps.size() - jumpers.pop() - 1) + 1);
            } catch (Exception e) {
                steps.add(1);
            }
        }
        Collections.reverse(steps);
        result.append(steps.stream().map(String::valueOf).collect(Collectors.joining(" ")));
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