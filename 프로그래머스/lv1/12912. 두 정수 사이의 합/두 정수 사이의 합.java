import java.util.stream.LongStream;

class Solution {
    public long solution(int x, int y) {
        int n = Math.abs(x - y) + 1;
        int a = Math.min(x, y);
        return n * (2L * a + n - 1) / 2;
    }
}