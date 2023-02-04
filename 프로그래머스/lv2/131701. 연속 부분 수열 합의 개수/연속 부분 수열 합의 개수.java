import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] nums = Stream.of(elements, elements).flatMapToInt(Arrays::stream).toArray();
        for (int i = 0; i < elements.length; i++)
            for (int j = 1; j <= elements.length; j++) 
                set.add(Arrays.stream(nums, i, i + j).sum());
        return set.size();
    }
}