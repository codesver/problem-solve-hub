import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        System.out.println(num >= 90 ? "A" : num >= 80 ? "B" : num >= 70 ? "C" : num >= 60 ? "D" : "F");
    }
}
