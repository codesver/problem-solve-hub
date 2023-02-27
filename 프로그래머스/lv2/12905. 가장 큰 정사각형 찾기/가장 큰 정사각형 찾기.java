import java.util.stream.IntStream;

class Solution {
    public int solution(int[][] board) {
        int R = board.length, C = board[0].length, max = 0;
        int[][] map = new int[R + 1][C + 1];
        IntStream.range(0, R).forEach(r -> System.arraycopy(board[r], 0, map[r + 1], 1, C));
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (map[r][c] == 1) {
                    int min = Math.min(map[r - 1][c - 1], Math.min(map[r - 1][c], map[r][c - 1]));
                    if (min != 0) map[r][c] = min + 1;
                    max = Math.max(max, map[r][c]);
                }
            }
        }
        return (int) Math.pow(max, 2);
    }
}