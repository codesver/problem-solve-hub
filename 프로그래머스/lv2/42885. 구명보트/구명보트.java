import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] people, int limit) {
        Deque<Integer> deque = Arrays.stream(people).sorted()
                .boxed().collect(Collectors.toCollection(LinkedList::new));
        int count = 0;
        while (!deque.isEmpty()) {
            if (deque.peekFirst() + deque.peekLast() <= limit) deque.pollFirst();
            deque.pollLast();
            count++;
        }
        return count;
    }
}