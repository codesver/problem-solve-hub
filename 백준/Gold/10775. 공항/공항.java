import java.io.*;
import java.util.stream.IntStream;

public class Main {

    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    final StringBuilder result = new StringBuilder();

    int[] gates;
    int count = 0;

    void solve() throws IOException {
        int GATE_NUM = Integer.parseInt(reader.readLine());
        int PLANE_NUM = Integer.parseInt(reader.readLine());
        gates = IntStream.rangeClosed(0, GATE_NUM).toArray();

        while (PLANE_NUM-- > 0) {
            int gi = Integer.parseInt(reader.readLine());
            int gate = find(gi);
            if (gate != 0) union(gate, gate - 1);
            else break;
        }

        result.append(count);
    }

    private int find(int gate) {
        return gate == gates[gate] ? gate : (gates[gate] = find(gates[gate]));
    }

    private void union(int gateA, int gateB) {
        gateA = find(gateA);
        gateB = find(gateB);
        gates[gateA] = gateB;
        count++;
    }

    void finish() throws IOException {
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