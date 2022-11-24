import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 9; i++)
            builder.append(num).append(" * ").append(i).append(" = ").append(num * i).append("\n");

        System.out.println(builder);
    }
}
