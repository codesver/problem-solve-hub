import java.util.HashSet;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        IntStream.of(nums).forEach(set::add);
        return Math.min(set.size(), nums.length / 2);
    }
}