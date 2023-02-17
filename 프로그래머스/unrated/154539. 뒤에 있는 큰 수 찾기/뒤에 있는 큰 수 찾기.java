import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] bln = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) stack.pop();
            if (stack.isEmpty()) bln[i] = -1;
            else bln[i] = stack.peek();
            stack.push(numbers[i]);
        }
        return bln;
    }
}
