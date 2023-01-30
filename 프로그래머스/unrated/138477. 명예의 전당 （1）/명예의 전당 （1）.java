import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int k, int[] scores) {
        Queue<Integer> top = new PriorityQueue<>();
        return Arrays.stream(scores).map(score -> {
            if (top.size() < k) top.add(score);
            else if (top.peek() < score) {
                top.poll();
                top.add(score);
            }
            return top.peek();
        }).toArray();
    }
}