import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        Queue<Integer> nums = Arrays.stream(citations).boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        while (!nums.isEmpty()) {
            if (nums.peek() >= nums.size()) return nums.size();
            nums.poll();
        }
        return 0;
    }
}