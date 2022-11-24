import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int first = Integer.parseInt(reader.readLine());
        int num = first;

        while (true) {
            int front = num / 10;
            int back = num % 10;
            int numNext = back * 10 + (front + back) % 10;
            if (first == numNext)
                break;
            count++;
            num = numNext;
        }

        System.out.println(count + 1);
    }
}