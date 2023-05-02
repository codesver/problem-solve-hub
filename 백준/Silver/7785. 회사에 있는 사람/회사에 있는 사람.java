import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        EntryInfo entryInfo = new EntryInfo();
        int entryNum = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        while (entryNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            entryInfo.entry(tokenizer.nextToken(), tokenizer.nextToken());
        }
        entryInfo.getEntryInfos().forEach(info -> result.append(info).append('\n'));
    }

    public void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}

class EntryInfo {

    private final Set<String> employees = new HashSet<>();

    public void entry(String employee, String entry) {
        if (entry.equals("enter")) employees.add(employee);
        else employees.remove(employee);
    }

    public List<String> getEntryInfos() {
        return employees.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}