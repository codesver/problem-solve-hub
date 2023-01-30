import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] nums = Arrays.stream(arr).sorted().filter(ele -> ele % divisor == 0).toArray();
        return nums.length == 0 ? new int[]{-1} : nums;
    }
}