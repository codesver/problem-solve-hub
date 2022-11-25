import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Set<Integer> set = new HashSet<>();
        int repeat = 10;
        while (repeat-- > 0) set.add(Integer.parseInt(reader.readLine()) % 42);
        result.append(set.size());
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

