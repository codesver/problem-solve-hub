import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        return Arrays.stream(array)
                .map(num -> (int) String.valueOf(num)
                        .chars()
                        .filter(ch -> ch == '7')
                        .count())
                .sum();
    }
}