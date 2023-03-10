import java.util.stream.LongStream;

class Solution {
    public long solution(int k, int d) {
        return LongStream.rangeClosed(0, d).filter(x -> x % k == 0)
                .map(x -> (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2)) / k + 1).sum();
    }
}