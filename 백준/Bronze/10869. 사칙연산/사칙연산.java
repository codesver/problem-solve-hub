import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder builder = new StringBuilder();

    private static String solution() throws IOException {
        String[] nums = reader.readLine().split(" ");
        int numA = Integer.parseInt(nums[0]);
        int numB = Integer.parseInt(nums[1]);
        return builder.append(numA + numB).append("\n")
                .append(numA - numB).append("\n")
                .append(numA * numB).append("\n")
                .append(numA / numB).append("\n")
                .append(numA % numB).toString();
    }

    public static void main(String[] args) throws IOException {
        String result = solution();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
