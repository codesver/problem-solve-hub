import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
        Map<Double, Long> map = new HashMap<>();
        for (int weight : weights) map.put((double) weight, map.getOrDefault((double) weight, 0L) + 1);
        return map.entrySet().stream().mapToLong(entry -> {
            Double key = entry.getKey();
            return entry.getValue() * (map.getOrDefault(key * 3 / 2, 0L)
                    + map.getOrDefault(key * 4 / 3, 0L)
                    + map.getOrDefault(key * 2, 0L))
                    + map.get(key) * (map.get(key) - 1) / 2;
        }).sum();
    }
}