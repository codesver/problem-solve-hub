import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        List<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toList());
        Queue<Integer> queue = new LinkedList<>(list);
        Queue<Integer> priority = new PriorityQueue<>(Comparator.reverseOrder()){{
            addAll(list);
        }};

        int rank = 1;
        while (!queue.isEmpty() && !priority.isEmpty()) {
            if (queue.peek() == priority.peek()) {
                if (location == 0) return rank;
                queue.poll();
                priority.poll();
                rank++;
            } else queue.offer(queue.poll());
            location = --location < 0 ? queue.size() - 1 : location;

        }
        return rank;
    }
}