import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int m, int[] section) {
        Queue<Integer> nums = Arrays.stream(section).boxed().collect(Collectors.toCollection(LinkedList::new));
        return (int) IntStream.range(0, nums.size()).takeWhile(i -> !nums.isEmpty()).peek(i -> {
            int block = nums.poll();
            while (!nums.isEmpty() && block + m - 1 >= nums.peek()) nums.poll();
        }).count();
    }
}