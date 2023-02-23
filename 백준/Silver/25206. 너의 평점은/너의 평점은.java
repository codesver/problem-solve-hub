import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        Map<String, Double> grades = new HashMap<>() {{
            put("A+", 4.5);
            put("A0", 4.0);
            put("B+", 3.5);
            put("B0", 3.0);
            put("C+", 2.5);
            put("C0", 2.0);
            put("D+", 1.5);
            put("D0", 1.0);
            put("F", 0.0);
        }};

        double sum = 0, scoreSum = 0;
        StringTokenizer tokenizer;
        for (int i = 0; i < 20; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            tokenizer.nextToken();
            double score = Double.parseDouble(tokenizer.nextToken());
            String grade = tokenizer.nextToken();
            if (!grade.equals("P")) {
                sum += score * grades.get(grade);
                scoreSum += score;
            }
        }
        result.append(sum / scoreSum);
    }

    public void finish() throws IOException {
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