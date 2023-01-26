import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] nums, int n) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            int a = Math.abs(o1 - n);
            int b = Math.abs(o2 - n);
            return a == b ? o2 - o1 : a - b;
        }).collect(Collectors.toList());
        return list.stream().mapToInt(num -> num).toArray();
    }
}