class Solution {

    private int maxExploration = 0;

    public int solution(int k, int[][] dungeons) {
        explore(dungeons, new boolean[dungeons.length], k, 0);
        return maxExploration;
    }

    private void explore(int[][] dungeons, boolean[] explored, int fatigue, int exploration) {
        boolean canExplore = false;
        for (int d = 0; d < dungeons.length; d++) {
            if (!explored[d] && fatigue >= dungeons[d][0]) {
                canExplore = explored[d] = true;
                explore(dungeons, explored, fatigue - dungeons[d][1], exploration + 1);
                explored[d] = false;
            }
        }
        if (!canExplore) maxExploration = Math.max(maxExploration, exploration);
    }
}