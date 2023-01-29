import java.util.Arrays;

class Solution {
    public int solution(String string) {
        return Arrays.stream(("0" + string).replaceAll("[A-Za-z]+", " ").split(" "))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}