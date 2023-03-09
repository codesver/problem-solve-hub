import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int[] consumed = {0, 0};
        Queue<Integer> enemies = new PriorityQueue<>(Comparator.reverseOrder());
        return (int) Arrays.stream(enemy).takeWhile(e -> {
            consumed[0] += e;
            enemies.offer(e);
            if (consumed[0] <= n) return true;
            else if (consumed[1] < k && !enemies.isEmpty()) {
                consumed[0] -= enemies.poll();
                consumed[1]++;
                return true;
            }
            return false;
        }).count();
    }
}