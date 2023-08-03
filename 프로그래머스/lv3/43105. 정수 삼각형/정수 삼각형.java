class Solution {
    public int solution(int[][] triangle) {
        int max = 0;
        for (int r = 1; r < triangle.length; r++) {
            for (int c = 0; c < triangle[r].length; c++) {
                max = Math.max(max, triangle[r][c] += Math.max(
                        c == 0 ? 0 : triangle[r - 1][c - 1],
                        c == triangle[r].length - 1 ? 0 : triangle[r - 1][c]
                ));
            }
        }
        return max;
    }
}