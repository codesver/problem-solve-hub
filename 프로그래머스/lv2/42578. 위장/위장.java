import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }

        int count = 1;
        for (Integer value : map.values()) count *= value + 1;
        return count - 1;
    }
}