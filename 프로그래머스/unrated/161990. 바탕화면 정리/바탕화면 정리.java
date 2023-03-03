class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = 51, minCol = 51;
        int maxRow = -1, maxCol = -1;
        for (int row = 0; row < wallpaper.length; row++) {
            char[] spaces = wallpaper[row].toCharArray();
            for (int col = 0; col < spaces.length; col++) {
                if (spaces[col] == '#') {
                    minRow = Math.min(minRow, row);
                    minCol = Math.min(minCol, col);
                    maxRow = Math.max(maxRow, row);
                    maxCol = Math.max(maxCol, col);
                }
            }
        }
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}