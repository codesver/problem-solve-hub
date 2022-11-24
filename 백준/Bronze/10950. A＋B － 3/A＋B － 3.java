import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int turn = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < turn; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            builder.append(Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken())).append("\n");
        }
        System.out.println(builder);
    }
}
