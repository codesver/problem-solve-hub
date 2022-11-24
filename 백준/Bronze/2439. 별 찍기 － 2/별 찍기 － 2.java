import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= num; i++)
            builder.append(" ".repeat(num - i)).append("*".repeat(i)).append("\n");
        System.out.println(builder);
    }
}
