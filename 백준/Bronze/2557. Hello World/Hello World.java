import java.io.*;

public class Main {

//    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void solution() throws IOException {
        writer.write("Hello World!");
    }

    public static void main(String[] args) throws IOException {
        solution();
        writer.flush();
        writer.close();
    }
}
