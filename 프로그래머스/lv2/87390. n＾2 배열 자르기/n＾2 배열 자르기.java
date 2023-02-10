import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public int[] solution(int n, long left, long right) {
        return IntStream.rangeClosed((int) (left / n + 1), (int) (right / n + 1))
                .flatMap(i -> Stream.of(IntStream.generate(() -> i).limit(i), IntStream.rangeClosed(i + 1, n)).flatMapToInt(j -> j))
                .skip(left % n).limit(right - left + 1).toArray();
    }
}
