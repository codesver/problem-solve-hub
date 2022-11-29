import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int[] counter = new int[10];
        int num = Integer.parseInt(reader.readLine());
        
        while (num != 0) {
            counter[num % 10]++;
            num = num / 10;
        }
        
        for (int i = 9; i >= 0; i--) 
            result.append(String.valueOf(i).repeat(counter[i]));
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