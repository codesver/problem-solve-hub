import java.util.stream.IntStream;

class Solution {
    public int solution(int[][] board) {
        int N = board.length;
        int[] nums = {-1, 0, 1};
        return IntStream.range(0, N).map(r -> (int) IntStream.range(0, N).filter(c -> {
            for (int row : nums) {
                for (int col : nums) {
                    try {
                        if (board[r + row][c + col] == 1) return false;
                    } catch (IndexOutOfBoundsException ignore) {

                    }
                }
            }
            return true;
        }).count()).sum();
    }
}