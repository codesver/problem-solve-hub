import java.util.Stack;

class Solution {
    public int solution(String s) {
        return new Stack<Character>() {{
            for (char ch : s.toCharArray())
                if (isEmpty() || peek() != ch) push(ch);
                else if (peek() == ch) pop();
        }}.isEmpty() ? 1 : 0;
    }
}