import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int number = Integer.parseInt(reader.readLine());
        int[][] people = new int[number][2];
        int[] ranks = new int[number];

        for (int i = 0; i < number; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            people[i][0] = Integer.parseInt(tokenizer.nextToken());
            people[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < number; i++)
            for (int j = 0; j < number; j++)
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1])
                    ranks[i]++;

        for (int rank : ranks) result.append(rank + 1).append(" ");
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