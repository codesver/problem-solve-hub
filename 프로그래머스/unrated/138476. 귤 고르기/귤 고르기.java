import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    static int count = 0, left = 0;

    public int solution(int k, int[] tangerine) {
        left = k;
        Arrays.stream(tangerine)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .mapToInt(e -> Math.toIntExact(e.getValue()))
                .forEach(v ->  {
                    if (left > 0) count++;
                    left -= v;
                });
        return count;
    }
}