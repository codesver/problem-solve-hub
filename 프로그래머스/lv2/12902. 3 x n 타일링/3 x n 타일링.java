class Solution {

    public final int MOD = 1_000_000_007;
    public long[] tiles = new long[5001];

    public long solution(int n) {
        tiles[0] = (tiles[2] = 3) - 2;
        for (int t = 4; t <= n; t += 2) tiles[t] = (tiles[t - 2] * 4 % MOD - tiles[t - 4] % MOD + MOD) % MOD;
        return tiles[n];
    }
}