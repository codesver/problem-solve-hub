class Solution {
    public int solution(int[] array, int n) {
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int num : array) {
            int d = Math.abs(num - n);
            if (diff > d) {
                diff = d;
                res = num;
            } else if (diff == d) res = Math.min(res, num);
        }
        return res;
    }
}