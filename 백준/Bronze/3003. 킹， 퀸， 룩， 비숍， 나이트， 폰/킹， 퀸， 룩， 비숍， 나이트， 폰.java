import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] nums = {1, 1, 2, 2, 2, 8};

        StringBuilder builder = new StringBuilder();
        for (int num : nums) builder.append(num - Integer.parseInt(tokenizer.nextToken())).append(" ");
        System.out.println(builder);
    }
}
