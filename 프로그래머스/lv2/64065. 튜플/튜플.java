import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {

    final Set<Integer> set = new HashSet<>();

    public int[] solution(String s) {
        return Arrays.stream(s.split("},[{]"))
                .map(this::convert)
                .sorted(Comparator.comparingInt(o -> o.length))
                .mapToInt(this::extract).toArray();
    }
    
    public int[] convert(String s) {
        return Arrays.stream(s.replaceAll("[{}]", "").split(","))
                .mapToInt(Integer::parseInt).toArray();   
    }

    public int extract(int[] nums) {
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                return num;
            }
        }
        return 0;
    }
}