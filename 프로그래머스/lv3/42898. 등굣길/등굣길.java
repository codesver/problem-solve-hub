class Solution {
    public int solution(int M, int N, int[][] puddles) {
        int[][] roads = new int[M][N];
        boolean[][] banned = new boolean[M][N];

        for (int[] puddle : puddles) banned[puddle[0] - 1][puddle[1] - 1] = true;
        for (int m = 1; m < M && !banned[m][0]; m++) roads[m][0] = 1;
        for (int n = 1; n < N && !banned[0][n]; n++) roads[0][n] = 1;

        for (int m = 1; m < M; m++)
            for (int n = 1; n < N; n++)
                if (!banned[m][n])
                    roads[m][n] = (roads[m - 1][n] + roads[m][n - 1]) % 1_000_000_007;

        return roads[M - 1][N - 1];
    }
}