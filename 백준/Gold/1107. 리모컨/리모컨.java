import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static final boolean[] isBroken = new boolean[10];

    private static void solution() throws IOException {
        int goalNumber = Integer.parseInt(reader.readLine());

        if (Integer.parseInt(reader.readLine()) == 0) {
            result.append(Math.min(Math.abs(100 - goalNumber), String.valueOf(goalNumber).length()));
        } else {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            while (tokenizer.hasMoreTokens()) isBroken[Integer.parseInt(tokenizer.nextToken())] = true;

            int count = Math.abs(100 - goalNumber);
            for (int i = 0; i <= 999999; i++)
                if (canClickButton(i))
                    count = Math.min(count, String.valueOf(i).length() + Math.abs(i - goalNumber));
            result.append(count);
        }
    }

    private static boolean canClickButton(int number) {
        char[] digits = String.valueOf(number).toCharArray();
        for (char digit : digits)
            if (isBroken[Character.getNumericValue(digit)])
                return false;
        return true;
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