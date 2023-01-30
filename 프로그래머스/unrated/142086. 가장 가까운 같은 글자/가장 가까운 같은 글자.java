import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        return IntStream.range(0, s.length()).map(i -> {
            char ch = s.charAt(i);
            int res = -1;
            if (map.containsKey(ch)) res = i - map.get(ch);
            map.put(ch, i);
            return res;
        }).toArray();
    }
}