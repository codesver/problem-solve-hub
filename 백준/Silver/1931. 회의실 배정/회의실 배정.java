import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Queue<Conference> conferences = new PriorityQueue<>((o1, o2) -> o1.endTime == o2.endTime ? o1.startTime - o2.startTime : o1.endTime - o2.endTime);
        int conferenceNum = Integer.parseInt(reader.readLine());
        while (conferenceNum-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            conferences.add(new Conference(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }

        int reservedTime = 0;
        int count = 0;
        while (!conferences.isEmpty()) {
            Conference conference = conferences.poll();
            if (conference.startTime >= reservedTime) {
                reservedTime = conference.endTime;
                count++;
            }
        }
        result.append(count);
    }

    static class Conference {
        int startTime, endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
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