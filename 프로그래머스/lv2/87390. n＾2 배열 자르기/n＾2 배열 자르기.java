import java.util.stream.LongStream;

class Solution {
    public int[] solution(int n, long left, long right) {
        return LongStream.rangeClosed(left, right)
                .mapToInt(e -> (int) (Math.max(e / n, e % n) + 1))
                .toArray();
    }
}