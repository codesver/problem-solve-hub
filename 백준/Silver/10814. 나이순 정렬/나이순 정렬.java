import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        Queue<User> users = new PriorityQueue<>((o1, o2) -> o1.age != o2.age ? o1.age - o2.age : o2.index - o1.index);
        while (size-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            users.add(new User(size, Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken()));
        }
        while (!users.isEmpty()) result.append(users.poll()).append("\n");
    }

    static class User {
        int index;
        int age;
        String name;

        public User(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
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