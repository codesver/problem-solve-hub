import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if (num < x)
                builder.append(num).append(" ");
        }

        System.out.println(builder);
    }
}
