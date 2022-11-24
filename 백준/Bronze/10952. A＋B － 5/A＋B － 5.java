import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int sum = Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken());

            if (sum == 0)
                break;
            builder.append(sum).append("\n");
        }

        System.out.println(builder);
    }
}
