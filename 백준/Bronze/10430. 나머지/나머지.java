import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        StringBuilder builder = new StringBuilder().append((a + b) % c).append("\n").append(((a % c) + (b % c)) % c).append("\n").append(a * b % c).append("\n").append(((a % c) * (b % c)) % c);
        System.out.println(builder);
    }
}
