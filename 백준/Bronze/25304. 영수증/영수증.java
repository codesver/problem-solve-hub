import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(reader.readLine());

        int num = Integer.parseInt(reader.readLine());
        int sum = 0;
        for (int i = 0; i < num; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            sum += Integer.parseInt(tokenizer.nextToken()) * Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(total == sum ? "Yes" : "No");
    }
}
