import java.util.Stack;
import java.util.stream.IntStream;

class Solution {
    public int solution(String s) {
        return (int) IntStream.range(0, s.length())
                .mapToObj(r -> s.substring(r) + s.substring(0, r))
                .filter(this::isRight).count();
    }

    private boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (ch == ')' || ch == '}' || ch == ']') return false;
                stack.push(ch);
            } else {
                if (match(stack.peek(), ch)) stack.pop();
                else stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char pre, char post) {
        return pre == '(' && post == ')' || pre == '{' && post == '}' || pre == '[' && post == ']';
    }
}