import java.util.Arrays;

class Solution {
    public int solution(String[] babbling) {
        return (int) Arrays.stream(babbling)
                .filter(value -> value.replaceAll("aya|ye|woo|ma", "").isEmpty())
                .count();
    }
}