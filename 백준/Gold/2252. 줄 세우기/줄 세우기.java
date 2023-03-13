import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Student {

    int sno, degrees;
    Set<Integer> students = new HashSet<>();

    public Student(int sno) {
        this.sno = sno;
    }
}

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, Student> map = IntStream.rangeClosed(1, N).boxed()
                .collect(Collectors.toMap(n -> n, Student::new));

        while (M-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int smaller = Integer.parseInt(tokenizer.nextToken());
            int bigger = Integer.parseInt(tokenizer.nextToken());

            map.get(bigger).degrees++;
            map.get(smaller).students.add(bigger);
        }

        Queue<Student> students = map.values().stream()
                .filter(student -> student.degrees == 0)
                .collect(Collectors.toCollection(LinkedList::new));

        while (!students.isEmpty()) {
            Student student = students.poll();
            for (int sno : student.students) {
                Student bigger = map.get(sno);
                bigger.degrees--;
                if (bigger.degrees == 0) students.offer(bigger);
            }
            result.append(student.sno).append(" ");
        }
    }

    private void finish() throws IOException {
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