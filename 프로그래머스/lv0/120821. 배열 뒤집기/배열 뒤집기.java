import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] nums) {
        return IntStream.range(0, nums.length)
                .map(i -> nums[nums.length - 1 - i])
                .toArray();
    }
}