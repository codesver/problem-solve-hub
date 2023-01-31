import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>() {{
            push('t');
            push(s.charAt(0));
        }};

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else if (stack.peek() == '(') stack.pop();
            else return false;
        }
        
        return stack.size() == 1;
    }
}