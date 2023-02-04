import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        return (int) IntStream.range(0, discount.length - 9).filter(i -> {
            Map<String, Long> items = Arrays.stream(discount, i, i + 10)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            for (int j = 0; j < want.length; j++)
                if (items.getOrDefault(want[j], 0L) < number[j]) return false;
            return true;
        }).count();
    }
}