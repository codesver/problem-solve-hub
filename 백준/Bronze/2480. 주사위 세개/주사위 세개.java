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

        int prize = a == b && b == c ?
                10000 + 1000 * a :
                a != b && b != c && c != a ?
                        100 * Math.max(Math.max(a, b), c) :
                        1000 + 100 * (a == b ? a : c);

        System.out.println(prize);
    }
}
