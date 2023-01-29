import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        return IntStream.range(1, n + 1).filter(num -> n % num == 0).toArray();
    }
}