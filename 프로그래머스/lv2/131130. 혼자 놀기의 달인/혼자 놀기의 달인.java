import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] cards) {
        List<Integer> counts = IntStream.range(0, cards.length).map(i -> {
            if (cards[i] != 0) {
                int next, count = 0;
                while (cards[i] != 0) {
                    count++;
                    next = cards[i] - 1;
                    cards[i] = 0;
                    i = next;
                }
                return count;
            } else return 0;
        }).filter(box -> box != 0).sorted().boxed().collect(Collectors.toList());
        return counts.size() == 1 ? 0 : counts.get(counts.size() - 1) * counts.get(counts.size() - 2);
    }
}