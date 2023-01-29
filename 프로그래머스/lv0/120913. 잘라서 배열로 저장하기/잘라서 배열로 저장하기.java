import java.util.stream.IntStream;

class Solution {
    public String[] solution(String my_str, int n) {
        return IntStream.range(0, my_str.length() / n + (my_str.length() % n == 0 ? 0 : 1))
                .mapToObj(index -> my_str.substring(index * n, Math.min(index * n + n, my_str.length())))
                .toArray(String[]::new);
    }
}