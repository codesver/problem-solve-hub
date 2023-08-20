class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0, from = 1, to;
        for (int station : stations) {
            to = station - w - 1;
            if (from <= to) count += requiredNumber(to - from + 1, w);
            from = station + w + 1;
        }
        if (from <= n) count += requiredNumber(n - from + 1, w);
        return count;
    }

    private int requiredNumber(int length, int w) {
        return (length / (2 * w + 1)) + (length % (2 * w + 1) > 0 ? 1 : 0);
    }
}