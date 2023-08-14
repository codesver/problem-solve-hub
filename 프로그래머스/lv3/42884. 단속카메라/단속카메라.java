import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));
        int count = 0, end = -30_001;
        for (int[] route : routes) {
            if (route[1] <= end) end = route[1];
            if (end < route[0]) {
                end = route[1];
                count++;
            }
        }
        return count;
    }
}