import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int personNum = Integer.parseInt(tokenizer.nextToken());
        int friendNum = Integer.parseInt(tokenizer.nextToken());
        Map<Integer, List<Integer>> friendship = IntStream.range(0, personNum).boxed()
                .collect(Collectors.toMap(pno -> pno, pno -> new ArrayList<>()));
        boolean[] connected = new boolean[personNum];
        while (friendNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int friendA = Integer.parseInt(tokenizer.nextToken());
            int friendB = Integer.parseInt(tokenizer.nextToken());
            friendship.get(friendA).add(friendB);
            friendship.get(friendB).add(friendA);
        }

        boolean flag = false;
        for (int pno = 0; pno < personNum; pno++) {
            connected[pno] = true;
            flag = search(friendship, connected, pno, 1);
            connected[pno] = false;
            if (flag) break;
        }
        result.append(flag ? 1 : 0);
    }

    private boolean search(Map<Integer, List<Integer>> friendship, boolean[] connected, int person, int count) {
        if (count == 5) return true;
        for (int friend : friendship.get(person)) {
            if (!connected[friend]) {
                connected[friend] = true;
                if (search(friendship, connected, friend, count + 1)) return true;
                connected[friend] = false;
            }
        }
        return false;
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