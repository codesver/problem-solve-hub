import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;

        for (int i : d) {
            budget -= i;
            count += budget >= 0 ? 1 : 0;
        }

        return count;
    }
}