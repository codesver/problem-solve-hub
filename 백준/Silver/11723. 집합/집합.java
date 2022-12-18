import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Set<Integer> S = new HashSet<>();
        int operations = Integer.parseInt(reader.readLine());
        while (operations-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String operation = tokenizer.nextToken();
            if (operation.equals("all")) S = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toSet());
            else if (operation.equals("empty")) S = new HashSet<>();
            else {
                int x = Integer.parseInt(tokenizer.nextToken());
                if (operation.equals("add")) S.add(x);
                else if (operation.equals("remove")) S.remove(x);
                else if (operation.equals("check")) result.append(S.contains(x) ? 1 : 0).append("\n");
                else if (operation.equals("toggle"))
                    if (S.contains(x)) S.remove(x);
                    else S.add(x);
            }
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