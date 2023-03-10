import java.util.stream.LongStream;

class Solution {
    public long solution(int k, int d) {
        return LongStream.iterate(0, x -> x <= d, x -> x + k)
                .map(x -> (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2)) / k + 1).sum();
    }
}