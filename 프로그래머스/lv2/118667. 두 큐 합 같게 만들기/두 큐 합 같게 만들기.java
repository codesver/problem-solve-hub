import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sumA = Arrays.stream(queue1).mapToLong(Long::valueOf).reduce(Long::sum).orElseThrow();
        long sumB = Arrays.stream(queue2).mapToLong(Long::valueOf).reduce(Long::sum).orElseThrow();
        long total = sumA + sumB;

        if (total % 2 != 0) {
            return -1;
        } else {
            long half = total / 2;
            int[] nums = Stream.of(queue1, queue2).flatMapToInt(Arrays::stream).toArray();
            int s = 0, e = queue1.length - 1, count = 0;
            try {
                while (sumA != half) {
                    count++;
                    if (sumA > half) sumA -= nums[s++];
                    else sumA += nums[++e];
                }
                return count;
            } catch (IndexOutOfBoundsException exception) {
                return -1;
            }
        }
    }
}