import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public int N;
    public final List<Integer> in = new ArrayList<>();
    public final Stack<Integer> post = new Stack<>();
    public final Stack<Integer> pre = new Stack<>();

    public void solve() throws IOException {
        init();
        search(0, in.size());
        while (!pre.isEmpty()) result.append(pre.pop()).append(" ");
    }

    private void init() throws IOException {
        N = Integer.parseInt(reader.readLine());
        Arrays.stream(reader.readLine().split(" ")).forEach(node -> in.add(Integer.parseInt(node)));
        Arrays.stream(reader.readLine().split(" ")).forEach(node -> post.push(Integer.parseInt(node)));
    }

    private void search(int from, int to) {
        if (!post.isEmpty()) {
            int node = post.pop();
            int mid = in.indexOf(node);

            if (to - mid > 1) search(mid + 1, to);
            if (mid - from >= 1) search(from, mid);
            pre.push(node);
        }
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