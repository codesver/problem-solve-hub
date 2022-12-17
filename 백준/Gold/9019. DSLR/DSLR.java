import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static Set<Integer> searched;
    private static Queue<N> ns;

    private static void solution() throws IOException {
        StringTokenizer tokenizer;
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());

            searched = new HashSet<>(Collections.singleton(from));
            ns = new LinkedList<>(Collections.singleton(new N(from, "")));

            while (!ns.isEmpty()) {
                N n = ns.poll();
                if (n.value == to) {
                    result.append(n.commands).append("\n");
                    break;
                }
                search(n.D, n, "D");
                search(n.S, n, "S");
                search(n.L, n, "L");
                search(n.R, n, "R");
            }
        }
    }

    private static void search(int dslr, N n, String D) {
        if (!searched.contains(dslr)) {
            ns.add(new N(dslr, n.commands + D));
            searched.add(dslr);
        }
    }

    static class N {

        int value;
        String commands;
        int D, S, L, R;

        public N(int value, String commands) {
            this.value = value;
            this.commands = commands;
            DSLR();
        }

        public void DSLR() {
            D = (value * 2) % 10000;
            S = value == 0 ? 9999 : value - 1;
            L = value % 1000 * 10 + value / 1000;
            R = value % 10 * 1000 + value / 10;
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