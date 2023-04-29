import java.io.*;
import java.util.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int lineNum = Integer.parseInt(reader.readLine());
        Stack<Ticket> ticketsWaiting = new Stack<>();
        Queue<Ticket> ticketsInLine = new LinkedList<>();
        Queue<Ticket> ticketsInOrder = new PriorityQueue<>();

        StringTokenizer tokenizer;
        while (lineNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            while (tokenizer.hasMoreTokens()) {
                Ticket ticket = new Ticket(tokenizer.nextToken());
                ticketsInLine.offer(ticket);
                ticketsInOrder.offer(ticket);
            }
        }

        while (!ticketsInOrder.isEmpty()) {
            Ticket ticket = ticketsInOrder.poll();
            if (!ticketsWaiting.isEmpty() && ticketsWaiting.peek().equals(ticket)) ticketsWaiting.pop();
            else if (!ticketsInLine.isEmpty() && ticketsInLine.peek().equals(ticket)) ticketsInLine.poll();
            else if (!ticketsInLine.isEmpty()) {
                ticketsWaiting.push(ticketsInLine.poll());
                ticketsInOrder.offer(ticket);
            }
            else break;
        }

        result.append(ticketsInOrder.isEmpty() ? "GOOD" : "BAD");
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

class Ticket implements Comparable<Ticket> {
    char type;
    int number;

    public Ticket(String ticket) {
        String[] infos = ticket.split("-");
        type = infos[0].charAt(0);
        number = Integer.parseInt(infos[1]);
    }

    @Override
    public int compareTo(Ticket t) {
        return type == t.type ? number - t.number : type - t.type;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "type=" + type +
                ", number=" + number +
                '}';
    }
}