class Solution {
    public int solution(int[][] dots) {
        final int LIMIT = 256;
        int maxX = -LIMIT, minX = LIMIT;
        int maxY = -LIMIT, minY = LIMIT;
        for (int[] dot : dots) {
            maxX = Math.max(maxX, dot[0]);
            minX = Math.min(minX, dot[0]);
            maxY = Math.max(maxY, dot[1]);
            minY = Math.min(minY, dot[1]);
        }
        return (maxX - minX) * (maxY - minY);
    }
}