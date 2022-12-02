import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        String word = reader.readLine();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++)
            for (int j = i + 1; j <= word.length(); j++) 
                set.add(word.substring(i, j));

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