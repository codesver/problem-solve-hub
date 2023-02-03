import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] T) {
        Map<Integer, Long> A = new HashMap<>();
        Map<Integer, Long> B = Arrays.stream(T).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return (int) Arrays.stream(T).filter(t -> {
            A.put(t, A.getOrDefault(t, 0L) + 1);
            if (B.get(t) == 1) B.remove(t);
            else B.put(t, B.get(t) - 1);
            return A.size() == B.size();
        }).count();
    }
}