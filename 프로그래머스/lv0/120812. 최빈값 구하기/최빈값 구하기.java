import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            max = Math.max(max, count);
        }
        int num = -1;
        for (Map.Entry<Integer, Integer> number : map.entrySet()) {
            if (number.getValue() == max) {
                if (num != -1) return -1;
                else num = number.getKey();
            }
        }
        return num;
    }
}
