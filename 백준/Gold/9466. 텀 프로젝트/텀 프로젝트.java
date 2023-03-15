import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum State {
    DEFAULT, SEARCHING, TEAMED, NON_TEAMED
}

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private int[] prefers;
    private State[] states;

    public void solve() throws IOException {
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int NUM = Integer.parseInt(reader.readLine());
            prefers = Arrays.stream(("0 " + reader.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
            states = Stream.generate(() -> State.DEFAULT).limit(NUM + 1).toArray(State[]::new);
            IntStream.rangeClosed(1, NUM).filter(num -> states[num] == State.DEFAULT)
                    .forEach(num -> search(num, new ArrayList<>()));
            result.append(Arrays.stream(this.states).filter(i -> i != State.TEAMED).count() - 1).append("\n");
        }
    }

    private void search(int num, List<Integer> searchList) {
        searchList.add(num);
        states[num] = State.SEARCHING;
        State state = states[prefers[num]];
        if (state == State.SEARCHING) {
            int cycleIdx = searchList.indexOf(prefers[num]);
            searchList.subList(0, cycleIdx).forEach(no -> states[no] = State.NON_TEAMED);
            searchList.subList(cycleIdx, searchList.size()).forEach(no -> states[no] = State.TEAMED);
        } else if (state == State.TEAMED || state == State.NON_TEAMED)
            searchList.forEach(no -> states[no] = State.NON_TEAMED);
        else if (state == State.DEFAULT) search(prefers[num], searchList);
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