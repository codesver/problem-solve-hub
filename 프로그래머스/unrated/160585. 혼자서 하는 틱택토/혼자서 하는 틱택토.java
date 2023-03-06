import java.util.Arrays;

class Solution {
    public int solution(String[] board) {
        char[][] ttt = Arrays.stream(board).map(String::toCharArray).toArray(char[][]::new);

        int[][] countO = {{0, 0, 0}, {0, 0, 0}, {0, 0}, {0}};
        int[][] countX = {{0, 0, 0}, {0, 0, 0}, {0, 0}, {0}};
        boolean wonO = false, wonX = false;

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (ttt[r][c] == 'O' && update(countO, r, c) && (wonO = true) && wonX) return 0;
                else if (ttt[r][c] == 'X' && update(countX, r, c) && (wonX = true) && wonO) return 0;


        return (countO[3][0] == countX[3][0] + 1 && (wonO || !wonX)) || (countO[3][0] == countX[3][0] && (wonX || !wonO)) ? 1 : 0;
    }

    private boolean update(int[][] count, int r, int c) {
        count[3][0]++;
        count[0][r]++;
        count[1][c]++;
        if (r == 0 && c == 0 || r == 2 && c == 2) count[2][0]++;
        else if (r == 0 && c == 2 || r == 2 && c == 0) count[2][1]++;
        else if (r == 1 && c == 1) {
            count[2][0]++;
            count[2][1]++;
        }
        return count[0][r] == 3 || count[1][c] == 3 || count[2][0] == 3 || count[2][1] == 3;
    }
}