import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static final Map<String, Character> map = new HashMap<>() {{
        put("000000", 'A');
        put("001111", 'B');
        put("010011", 'C');
        put("011100", 'D');
        put("100110", 'E');
        put("101001", 'F');
        put("110101", 'G');
        put("111010", 'H');
    }};

    private static void solution() throws IOException {
        int L = Integer.parseInt(reader.readLine());
        String codes = reader.readLine();
        for (int i = 0; i < L; i++) {
            StringBuilder code = new StringBuilder(codes.substring(i * 6, i * 6 + 6));
            if (map.containsKey(code.toString())) result.append(map.get(code.toString()));
            else {
                for (int j = 0; j < 6; j++) {
                    char ch = code.charAt(j);
                    code.setCharAt(j, ch == '1' ? '0' : '1');
                    if (map.containsKey(code.toString())) {
                        result.append(map.get(code.toString()));
                        break;
                    }
                    code.setCharAt(j, ch);
                }
                if (result.length() != i + 1) {
                    result.delete(0, result.length());
                    result.append(i + 1);
                    break;
                }
            }
        }
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