import java.util.Stack;

class Solution {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Integer> give = new Stack<>();
        Stack<Integer> take = new Stack<>();
        for (int delivery : deliveries) give.push(delivery);
        for (int pickup : pickups) take.push(pickup);

        long distance = 0;
        while (!give.isEmpty() || !take.isEmpty()) distance += Math.max(calc(give, cap), calc(take, cap)) * 2L;

        return distance;
    }

    private int calc(Stack<Integer> packs, int cap) {
        int distance = 0;
        while (cap != 0 && !packs.isEmpty()) {
            if (packs.peek() == 0) packs.pop();
            else {
                distance = Math.max(distance, packs.size());
                if (packs.peek() <= cap) cap -= packs.pop();
                else {
                    packs.push(packs.pop() - cap);
                    cap = 0;
                }
            }
        }
        return distance;
    }
}