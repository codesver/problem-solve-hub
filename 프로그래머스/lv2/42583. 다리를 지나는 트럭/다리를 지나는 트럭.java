import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int time = 0, sum = 0;
        Queue<Integer> bridge = IntStream.generate(() -> 0)
                .limit(bridgeLength).boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> trucks = Arrays.stream(truckWeights).boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        while (!trucks.isEmpty()) {
            time++;
            if (!bridge.isEmpty()) sum -= bridge.poll();
            if (!trucks.isEmpty() && sum + trucks.peek() <= weight) {
                int truck = trucks.poll();
                sum += truck;
                bridge.offer(truck);
            } else bridge.offer(0);
        }
        return time + bridge.size();
    }
}