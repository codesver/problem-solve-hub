import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] A, int[] B) {
        Queue<Integer> as = new PriorityQueue<>(Comparator.reverseOrder()) {{
            Arrays.stream(A).forEach(this::add);
        }};
        
        Queue<Integer> bs = new PriorityQueue<>(Comparator.reverseOrder()) {{
            Arrays.stream(B).forEach(this::add);
        }};

        while (!as.isEmpty())
            if (as.poll() < bs.peek()) bs.poll();

        return B.length - bs.size();
    }
}