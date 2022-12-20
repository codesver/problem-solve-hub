import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int siteNum = Integer.parseInt(tokenizer.nextToken());
        int pwSiteNum = Integer.parseInt(tokenizer.nextToken());
        Map<String, String> siteAndPw = new HashMap<>();
        while (siteNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            siteAndPw.put(tokenizer.nextToken(), tokenizer.nextToken());
        }
        while (pwSiteNum-- > 0) result.append(siteAndPw.get(reader.readLine())).append("\n");
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