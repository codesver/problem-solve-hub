import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        List<Integer> list = new ArrayList<>(Collections.singleton(0));
        for (int n = 1; n <= N; n++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if (list.get(list.size() - 1) < num) list.add(num);
            else binarySearch(list, num);
        }

        result.append(list.size() - 1);
    }

    private void binarySearch(List<Integer> list, int num) {
        int left = 0, right = list.size() - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (list.get(mid) >= num) right = mid;
            else left = mid + 1;
        }
        list.set(left, num);
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