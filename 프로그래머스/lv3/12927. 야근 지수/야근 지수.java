import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> nums = Arrays.stream(works).boxed()
                .collect(Collectors.toCollection((Supplier<Queue<Integer>>) () ->
                        new PriorityQueue<>(Comparator.reverseOrder())));

        while (n-- > 0) {
            Integer num = nums.poll();
            if (num == 0) return 0;
            nums.offer(num - 1);
        }
        
        return nums.stream().mapToLong(num -> (long) Math.pow(num, 2)).sum();
    }
}