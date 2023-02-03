import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> height = new ArrayList<>(Collections.singleton(k));
        while (k != 1) {
            if (k % 2 == 0) height.add(k /= 2);
            else height.add(k = 3 * k + 1);
        }
        double[] area = IntStream.range(0, height.size() - 1)
                .mapToDouble(i -> (height.get(i) + height.get(i + 1)) / (double) 2).toArray();
        return Arrays.stream(ranges)
                .mapToDouble(range -> {
                    int from = range[0];
                    int to = area.length + range[1];
                    return from <= to ? Arrays.stream(area, from, to).sum() : -1;
                }).toArray();
    }
}