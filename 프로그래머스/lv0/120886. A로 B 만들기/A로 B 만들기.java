import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : after.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        for (char ch : before.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) return 0;
            else if (count == 1) map.remove(ch);
            else map.put(ch, count - 1);
        }
        return 1;
    }
}