import java.time.LocalTime;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(String[][] bookTime) {
        Queue<LocalTime> ends = new PriorityQueue<>(LocalTime::compareTo);
        Arrays.stream(bookTime).sorted((o1, o2) -> {
            LocalTime l = LocalTime.parse(o1[0]);
            LocalTime r = LocalTime.parse(o2[0]);
            return l.compareTo(r) == 0 ?
                    LocalTime.parse(o1[1]).compareTo(LocalTime.parse(o2[1])) :
                    l.compareTo(r);
        }).forEach(book -> {
            if (!ends.isEmpty()
                    && ends.peek().isBefore(LocalTime.parse("23:49"))
                    && ends.peek().plusMinutes(9).isBefore(LocalTime.parse(book[0])))
                ends.poll();
            ends.add(LocalTime.parse(book[1]));
        });
        return ends.size();
    }
}