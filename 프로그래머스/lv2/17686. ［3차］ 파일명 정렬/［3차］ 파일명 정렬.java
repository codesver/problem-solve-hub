import java.util.stream.IntStream;

public class Solution {
    public String[] solution(String[] files) {
        return IntStream.range(0, files.length)
                .mapToObj(order -> new File(files[order], order))
                .sorted()
                .map(File::getName)
                .toArray(String[]::new);
    }
}

class File implements Comparable<File> {

    private final String original, head;
    private final int number, order;

    public File(String file, int order) {
        original = file;
        head = file.replaceFirst("[0-9]+.*", "").toLowerCase();
        number = Integer.parseInt(file.substring(head.length()).replaceFirst("[^0-9]+.*", ""));
        this.order = order;
    }

    public String getName() {
        return original;
    }

    @Override
    public int compareTo(File o) {
        if (!head.equals(o.head)) return head.compareTo(o.head);
        if (number != o.number) return number - o.number;
        return order - o.order;
    }
}