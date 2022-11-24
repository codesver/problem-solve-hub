import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int original = Integer.parseInt(reader.readLine());
        int number = original;
        int count = 0;

        while (true) {
            count++;
            int front = number / 10;
            int back = number % 10;
            int nextNumber = back * 10 + (front + back) % 10;
            if (original == nextNumber)
                break;
            number = nextNumber;
        }

        result.append(count);
    }

    private static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}

