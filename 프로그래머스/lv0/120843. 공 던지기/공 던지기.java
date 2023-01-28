import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers, int k) {
        Queue<Integer> nums = Arrays.stream(numbers).boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        while (k-- > 1) {
            nums.add(nums.poll());
            nums.add(nums.poll());
        }
        return nums.peek();
    }
}