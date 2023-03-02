import java.util.stream.IntStream;

class Solution {
    public int[] solution(long begin, long end) {
        return IntStream.rangeClosed((int) begin, (int) end).map(n -> {
            if (n == 1) return 0;
            int div = 1;
            for (int d = 2; d <= Math.sqrt(n); d++) {
                if (n % d == 0) {
                    div = d;
                    if (n / d <= 10_000_000) return n / d;
                }
            }
            return div;
        }).toArray();
    }
}