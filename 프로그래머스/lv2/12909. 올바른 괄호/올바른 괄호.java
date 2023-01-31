import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('t');
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                Character peek = stack.peek();
                if (peek == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.size() == 1;
    }
}