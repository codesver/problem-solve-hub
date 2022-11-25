import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        List<Boolean> list = new ArrayList<>(Collections.nCopies(30, false));
        int repeat = 28;
        while (repeat-- > 0)
            list.set(Integer.parseInt(reader.readLine()) - 1, true);
        result.append(list.indexOf(false) + 1)
                .append("\n")
                .append(list.lastIndexOf(false) + 1);
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

