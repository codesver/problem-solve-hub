import java.util.ArrayList;
import java.util.List;

public class Solution {

    int R, C;
    char[][] tilt;
    boolean[][][] passed;

    final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[] solution(String[] grid) {
        R = grid.length;
        C = grid[0].length();
        passed = new boolean[R][C][4];
        tilt = new char[R][C];
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++) tilt[r][c] = grid[r].charAt(c);
        
        List<Integer> counts = new ArrayList<>();
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                for (int d = 0; d < 4; d++)
                    if (!passed[r][c][d]) counts.add(pass(r, c, d));
        return counts.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    private int pass(int r, int c, int d) {
        int count = 0;

        while (true) {
            if (passed[r][c][d]) break;
            count++;
            passed[r][c][d] = true;

            if (tilt[r][c] == 'L') d = (d + 3) % 4;
            else if (tilt[r][c] == 'R') d = (d + 1) % 4;

            r = (r + move[d][0] + R) % R;
            c = (c + move[d][1] + C) % C;
        }

        return count;
    }
}
