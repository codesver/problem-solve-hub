import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] line : lines) {
            for (int x = line[0]; x < line[1]; x++) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        int sum = 0;
        for (Integer value : map.values()) {
            if (value != 1) sum++;
        }
        return sum;
    }
}