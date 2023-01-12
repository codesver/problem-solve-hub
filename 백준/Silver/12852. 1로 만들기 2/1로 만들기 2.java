import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int NUM;
    private final static List<Info> infos = new ArrayList<>();

    private static void solution() throws IOException {
        init();
        IntStream.range(1, NUM).boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(Main::ignition);
        solve();
    }

    private static void init() throws IOException {
        NUM = Integer.parseInt(reader.readLine());
        IntStream.rangeClosed(0, NUM).forEach(num -> infos.add(new Info(num)));
    }

    private static void ignition(int num) {
        infos.get(num)
                .addInfo(num * 3 <= NUM ?
                                minInfo(infos.get(num * 3), infos.get(num * 2), infos.get(num + 1)) :
                                num * 2 <= NUM ?
                                        minInfo(infos.get(num * 2), infos.get(num + 1)) :
                                        infos.get(num + 1)
                );
    }

    private static Info minInfo(Info... infos) {
        int minCount = Integer.MAX_VALUE;
        Info minInfo = null;
        for (Info info : infos) {
            if (minCount > info.count) {
                minCount = info.count;
                minInfo = info;
            }
        }
        return minInfo;
    }

    private static void solve() {
        Info info = infos.get(1);
        result.append(info.count).append("\n");
        result.append(info);
    }

    static class Info {

        int num = 0;
        int count = 0;
        Info parent = null;

        public Info(int num) {
            this.num = num;
        }

        public void addInfo(Info info) {
            parent = info;
            count = info.count + 1;
        }

        @Override
        public String toString() {
            if (parent != null) return parent + " " + num;
            else return String.valueOf(num);
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