import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    static class Lecture {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        Queue<Lecture> lecturesStart = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        StringTokenizer tokenizer;
        while (N-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            Lecture lecture = new Lecture(start, end);
            lecturesStart.offer(lecture);
        }

        int rooms = 0;
        Queue<Lecture> lecturesEnd = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        while (!lecturesStart.isEmpty()) {
            Lecture lecture = lecturesStart.poll();
            while (!lecturesEnd.isEmpty() && lecture.start >= lecturesEnd.peek().end) lecturesEnd.poll();
            lecturesEnd.offer(lecture);
            rooms = Math.max(rooms, lecturesEnd.size());
        }

        result.append(rooms);
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