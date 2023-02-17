import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        Queue<Integer> scales = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        while (!scales.isEmpty() && scales.peek() < K) {
            count++;
            int min = scales.poll();
            if (scales.isEmpty()) return -1;
            scales.offer(min + scales.poll() * 2);
        }
        return count;
    }
}