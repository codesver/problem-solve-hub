import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int count = 0;

        for (int move : moves) {
            int num = -1;
            for (int[] floor : board) {
                num = floor[move - 1];
                if (num != 0) {
                    floor[move - 1] = 0;
                    if (stack.peek() == num) {
                        stack.pop();
                        count += 2;
                    } else
                        stack.push(num);
                    break;
                }
            }
        }

        return count;
    }
}