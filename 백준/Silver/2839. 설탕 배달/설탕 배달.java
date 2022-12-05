import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int sugar = Integer.parseInt(reader.readLine());
        int count = 0;
        count += sugar / 5;
        sugar %= 5;
        result.append(sugar == 0 ?
                count :
                sugar == 1 ?
                        (count >= 1 ? count + 1 : -1) :
                        sugar == 2 ?
                                (count >= 2 ? count + 2 : -1) :
                                sugar == 3 ?
                                        count + 1 :
                                        (count >= 1 ? count + 2 : -1));
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