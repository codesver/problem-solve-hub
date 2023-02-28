import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int R = land.length;
        for (int r = 1; r < R; r++) {
            land[r][0] += Math.max(land[r - 1][1], Math.max(land[r - 1][2], land[r - 1][3]));
            land[r][1] += Math.max(land[r - 1][0], Math.max(land[r - 1][2], land[r - 1][3]));
            land[r][2] += Math.max(land[r - 1][0], Math.max(land[r - 1][1], land[r - 1][3]));
            land[r][3] += Math.max(land[r - 1][0], Math.max(land[r - 1][1], land[r - 1][2]));
        }
        return Arrays.stream(land[R - 1]).max().orElseThrow();
    }
}