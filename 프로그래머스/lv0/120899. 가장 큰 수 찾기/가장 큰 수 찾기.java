import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int index = Arrays.stream(array).boxed().collect(Collectors.toList()).indexOf(max);
        return new int[]{max, index};
    }
}