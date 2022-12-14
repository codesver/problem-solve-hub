import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int pokemonNum = Integer.parseInt(tokenizer.nextToken());
        int questionNum = Integer.parseInt(tokenizer.nextToken());

        Map<String, Integer> pokemonMap = new HashMap<>();
        List<String> pokemonList = new ArrayList<>();
        for (int serial = 1; serial <= pokemonNum; serial++) {
            String pokemon = reader.readLine();
            pokemonMap.put(pokemon, serial);
            pokemonList.add(pokemon);
        }

        while (questionNum-- > 0) {
            String question = reader.readLine();
            if (question.matches("[1-9][0-9]*")) result.append(pokemonList.get(Integer.parseInt(question) - 1));
            else result.append(pokemonMap.get(question));
            result.append("\n");
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