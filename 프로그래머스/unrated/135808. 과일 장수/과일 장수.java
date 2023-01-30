import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int k, int m, int[] score) {
        Queue<Integer> scores = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(score).forEach(scores::add);
        int sum = 0;
        while (scores.size() >= m) {
            int n = m - 1;
            while (n-- > 0) scores.poll();
            sum += scores.poll() * m;
        }
        return sum;
    }
}