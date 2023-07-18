import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] times = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for (int time = 0; time < prices.length; time++) {
            while (!stack.isEmpty() && prices[time] < prices[stack.peek()])
                times[stack.peek()] = time - stack.pop();
            stack.push(time);
        }

        while (!stack.isEmpty()) times[stack.peek()] = prices.length - stack.pop() - 1;

        return times;
    }
}