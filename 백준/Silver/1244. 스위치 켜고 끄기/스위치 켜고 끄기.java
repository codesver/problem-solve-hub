import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    public static int SWITCH;
    public static int[] switches;

    public static void solution() throws IOException {
        SWITCH = Integer.parseInt(reader.readLine());
        switches = Arrays.stream(("0 " + reader.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        int STUD = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        while (STUD-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            change(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }

        for (int s = 1; s <= SWITCH; s++) {
            result.append(switches[s]).append(" ");
            if (s % 20 == 0) result.append("\n");
        }
    }

    public static void change(int gender, int sn) {
        if (gender == 1) {
            for (int s = sn; s <= SWITCH; s += sn) switches[s] = (switches[s] + 1) % 2;
        } else for (int s = 0; s <= Math.min(SWITCH - sn, sn - 1); s++) {
            if (s == 0) switches[sn] = (switches[sn] + 1) % 2;
            else if (switches[sn + s] == switches[sn - s]) {
                switches[sn + s] = (switches[sn + s] + 1) % 2;
                switches[sn - s] = (switches[sn - s] + 1) % 2;
            } else break;
        }
    }

    public static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}