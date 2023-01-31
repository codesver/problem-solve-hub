import java.util.Stack;

class Solution {
    public int solution(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);

        for (int i = 0; i < n - 1; i++) {
            int a = stack.pop();
            int b = stack.pop();
            int num = a + b;
            stack.push(a);
            stack.push(num % 1234567);
        }

        return stack.peek();
    }
}