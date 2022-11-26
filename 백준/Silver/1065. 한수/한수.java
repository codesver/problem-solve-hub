import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxNumber = Integer.parseInt(reader.readLine());
        long hansooCount = IntStream.range(1, maxNumber + 1).filter(number -> {
            if (number < 100) return true;
            else if (number == 1000) return false;
            else return ((number / 100) - (number / 10 % 10)) == ((number / 10 % 10) - (number % 10));
        }).count();
        System.out.println(hansooCount);
    }
}
