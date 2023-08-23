import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> category = Arrays.stream(gems).collect(Collectors.toSet());

        int minLength = 100_001, start = 0, end = 0;

        Map<String, Integer> basket = new HashMap<>();

        int from = 1, to;
        for (int g = 1; g <= gems.length; g++) {
            to = g;
            basket.merge(gems[to - 1], 1, Integer::sum);
            while (basket.getOrDefault(gems[from - 1], 0) > 1)
                basket.merge(gems[from++ - 1], -1, Integer::sum);
            if (basket.keySet().size() == category.size() && to - from + 1 < minLength)
                minLength = (end = to) - (start = from) + 1;
        }

        return new int[]{start, end};
    }
}