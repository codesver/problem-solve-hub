import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        return direction.equals("right") ?
                merge(new int[]{numbers[numbers.length - 1]}, Arrays.copyOfRange(numbers, 0, numbers.length - 1)) :
                merge(Arrays.copyOfRange(numbers, 1, numbers.length), new int[]{numbers[0]});
    }

    public int[] merge(int[] front, int[] back) {
        return Stream.of(front, back).flatMapToInt(Arrays::stream).toArray();
    }
}