import java.util.stream.IntStream;

class Solution {
    public int[] solution(int num) {
        return IntStream.rangeClosed(1, num).filter(n -> n % 2 == 1).toArray();
    }
}