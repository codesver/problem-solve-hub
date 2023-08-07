class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int[] nums = new int[n];
        for (int i = 0; i < n - s % n; i++) nums[i] = s / n;
        for (int i = n - s % n; i < n; i++) nums[i] = s / n + 1;
        return nums;
    }
}