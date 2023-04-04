import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        Map<String, Integer> map = IntStream.range(0, name.length).boxed()
                .collect(Collectors.toMap(i -> name[i], i -> yearning[i]));
        return Arrays.stream(photos)
                .mapToInt(photo -> Arrays.stream(photo)
                        .mapToInt(person -> map.getOrDefault(person, 0))
                        .sum())
                .toArray();
    }
}