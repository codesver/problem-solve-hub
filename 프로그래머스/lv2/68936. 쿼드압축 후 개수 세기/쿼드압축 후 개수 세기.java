class Solution {

    public int[] count = new int[2];

    public int[] solution(int[][] map) {
        search(map, 0, 0, map.length);
        return count;
    }

    public void search(int[][] map, int sr, int sc, int len) {
        int type = map[sr][sc];
        for (int r = sr; r < sr + len; r++) {
            for (int c = sc; c < sc + len; c++) {
                if (map[r][c] != type) {
                    search(map, sr, sc, len / 2);
                    search(map, sr + len / 2, sc, len / 2);
                    search(map, sr, sc + len / 2, len / 2);
                    search(map, sr + len / 2, sc + len / 2, len / 2);
                    return;
                }
            }
        }
        count[type]++;
    }
}