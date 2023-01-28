import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("[A-Za-z]", "").split(""))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}