import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        List<Integer> dp = new ArrayList<>();
        int G = Integer.parseInt(reader.readLine());
        if (G == 1) result.append(reader.readLine());
        else if (G == 2) result.append(Integer.parseInt(reader.readLine()) + Integer.parseInt(reader.readLine()));
        else {
            int preWine = 0;
            dp.add(0);
            dp.add(0);
            dp.add(0);
            while (G-- > 0) {
                int wine = Integer.parseInt(reader.readLine());
                dp.add(
                        Math.max(
                                Math.max(dp.get(dp.size() - 1), dp.get(dp.size() - 2) + wine),
                                dp.get(dp.size() - 3) + preWine + wine
                        )
                );
                preWine = wine;
            }
            result.append(dp.get(dp.size() - 1));
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