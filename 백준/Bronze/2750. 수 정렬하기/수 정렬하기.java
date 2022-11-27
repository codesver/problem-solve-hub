import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        List<Integer> nums = new ArrayList<>();
        while (size-- > 0) nums.add(Integer.parseInt(reader.readLine()));
        nums.sort(Comparator.comparingInt(o -> o));
        for (Integer num : nums) result.append(num).append("\n");
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