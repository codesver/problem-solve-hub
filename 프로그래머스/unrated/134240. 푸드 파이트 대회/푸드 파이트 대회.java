import java.util.stream.IntStream;

class Solution {
    public String solution(int[] food) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(1, food.length).forEach(i -> builder.append(String.valueOf(i).repeat(food[i] / 2)));
        return builder.toString() + "0" + builder.reverse();
    }
}