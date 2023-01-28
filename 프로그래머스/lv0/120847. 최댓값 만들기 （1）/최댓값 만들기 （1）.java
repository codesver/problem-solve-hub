import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int[] nums = Arrays.stream(numbers).sorted().toArray();
        return nums[nums.length - 1] * nums[nums.length - 2];
    }
}