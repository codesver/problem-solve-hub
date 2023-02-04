import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> main = IntStream.rangeClosed(1, order.length)
                .boxed().collect(Collectors.toCollection(LinkedList::new));
        Stack<Integer> sub = new Stack<>();

        return (int) Arrays.stream(order).takeWhile(box -> {
            while (!main.isEmpty() && main.peek() <= box) {
                if (main.peek() == box) return main.poll() > 0;
                sub.push(main.poll());
            }
            return !sub.isEmpty() && sub.peek() == box && sub.pop() > 0;
        }).count();
    }
}