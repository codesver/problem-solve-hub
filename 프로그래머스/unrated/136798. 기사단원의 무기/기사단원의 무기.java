import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {
    public int solution(int number, int limit, int power) {
        return IntStream.rangeClosed(1, number).map(num -> {
            int knight = power(num);
            if (knight > limit) return power;
            else return knight;
        }).sum();
    }

    public int power(int num) {
        Set<Integer> set = new HashSet<>();
        IntStream.rangeClosed(1, (int) Math.sqrt(num)).forEach(n -> {
            if (num % n == 0) {
                set.add(n);
                set.add(num / n);
            }
        });
        return set.size();
    }
}