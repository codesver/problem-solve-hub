import java.util.ArrayList;
import java.util.List;

class Solution {

    public int ROW, COL;
    public int[][] ocean;

    public int[] solution(String[] maps) {
        init(maps);
        return search();
    }

    public void init(String[] maps) {
        ROW = maps.length;
        COL = maps[0].length();
        ocean = new int[ROW + 2][COL + 2];
        for (int r = 1; r <= ROW; r++) {
            String row = maps[r - 1];
            for (int c = 1; c <= COL; c++) {
                char ch = row.charAt(c - 1);
                ocean[r][c] = Character.isDigit(ch) ? Character.getNumericValue(ch) : 0;
            }
        }
    }

    public int[] search() {
        List<Integer> survives = new ArrayList<>();
        for (int r = 1; r <= ROW; r++) {
            for (int c = 1; c <= COL; c++) {
                if (ocean[r][c] != 0) {
                    survives.add(dfs(r, c));
                }
            }
        }
        return survives.size() == 0 ?
                new int[]{-1} :
                survives.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public int dfs(int r, int c) {
        int sum = ocean[r][c];
        ocean[r][c] = 0;
        if (ocean[r - 1][c] != 0) sum += dfs(r - 1, c);
        if (ocean[r][c + 1] != 0) sum += dfs(r, c + 1);
        if (ocean[r + 1][c] != 0) sum += dfs(r + 1, c);
        if (ocean[r][c - 1] != 0) sum += dfs(r, c - 1);
        return sum;
    }
}