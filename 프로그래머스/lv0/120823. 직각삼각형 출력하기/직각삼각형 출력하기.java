import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        for (int r = 1; r <= n; r++) builder.append("*".repeat(r)).append("\n");
        writer.write(builder.toString());
        writer.flush();
        writer.close();
    }
}