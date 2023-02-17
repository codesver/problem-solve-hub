import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = Arrays.stream(cards1).collect(Collectors.toCollection(LinkedList::new));
        Queue<String> queue2 = Arrays.stream(cards2).collect(Collectors.toCollection(LinkedList::new));
        for (String g : goal) {
            if (!queue1.isEmpty() && queue1.peek().equals(g)) queue1.poll();
            else if (!queue2.isEmpty() && queue2.peek().equals(g)) queue2.poll();
            else return "No";
        }
        return "Yes";
    }
}