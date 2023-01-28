import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[][] solution(int[] nums, int n) {
        return IntStream.range(0, nums.length / n)
                .mapToObj(i -> Arrays.copyOfRange(nums, i * n, (i + 1) * n))
                .toArray(int[][]::new);
    }
}