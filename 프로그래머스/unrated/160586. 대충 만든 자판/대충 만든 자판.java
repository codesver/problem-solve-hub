import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> keyboard = new HashMap<>();
        for (String key : keymap) {
            for (int c = 1; c <= key.length(); c++) {
                char ch = key.charAt(c - 1);
                keyboard.put(ch, Math.min(c, keyboard.getOrDefault(ch, 101)));
            }
        }
        return Arrays.stream(targets).mapToInt(target -> {
            int sum = 0;
            for (char ch : target.toCharArray())
                if (keyboard.containsKey(ch)) sum += keyboard.get(ch);
                else return -1;
            return sum;
        }).toArray();
    }
}