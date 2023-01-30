class Solution {
    public int[] solution(int[] nums) {
        int[] count = new int[2];
        for (int num : nums)
            if (num % 2 == 0) count[0]++;
            else count[1]++;
        return count;
    }
}