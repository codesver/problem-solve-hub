import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Building {

    int time;
    boolean built = false;
    final List<Integer> preWorks = new ArrayList<>();

    public Building(int time) {
        this.time = time;
    }

    public void addPreWork(int buildingNum) {
        preWorks.add(buildingNum);
    }

    public int getBuiltTime(List<Building> buildings) {
        if (!built) {
            int max = 0;
            for (Integer preWork : preWorks) {
                max = Math.max(max, buildings.get(preWork).getBuiltTime(buildings));
            }
            time += max;
            built = true;
        }
        return time;
    }
}

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer;
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int buildingNum = Integer.parseInt(tokenizer.nextToken());
            int ruleNum = Integer.parseInt(tokenizer.nextToken());
            List<Building> buildings = Arrays.stream(("0 " + reader.readLine()).split(" "))
                    .map(time -> new Building(Integer.parseInt(time))).collect(Collectors.toList());
            
            while (ruleNum-- > 0) {
                tokenizer = new StringTokenizer(reader.readLine());
                int pre = Integer.parseInt(tokenizer.nextToken());
                int post = Integer.parseInt(tokenizer.nextToken());
                buildings.get(post).addPreWork(pre);
            }

            result.append(buildings.get(Integer.parseInt(reader.readLine())).getBuiltTime(buildings)).append("\n");
        }
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