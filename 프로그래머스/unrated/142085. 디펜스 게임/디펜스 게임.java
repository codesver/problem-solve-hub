import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> enemies = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            n -= e;
            enemies.offer(e);
            if (n < 0 && k > 0 && !enemies.isEmpty()) {
                n += enemies.poll();
                k--;
            } else if (n < 0) return i;
        }
        return enemy.length;
    }
}