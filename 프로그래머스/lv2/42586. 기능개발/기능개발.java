import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> times = IntStream.range(0, progresses.length)
                .map(i -> {
                    int remain = 100 - progresses[i];
                    return remain / speeds[i] + ((remain % speeds[i]) != 0 ? 1 : 0);
                }).boxed().collect(Collectors.toCollection(LinkedList::new));
        return IntStream.range(0, times.size())
                .takeWhile(i -> !times.isEmpty())
                .map(i -> {
                    int time = times.poll(), count = 1;
                    while (!times.isEmpty() && time >= times.peek()) {
                        times.poll();
                        count++;
                    }
                    return count;
                }).toArray();
    }
}