class Solution {
    public int[] solution(long n) {
        String[] number = String.valueOf(n).split("");
        int[] nums = new int[number.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(number[number.length - 1 - i]);
        }
        return nums;
    }
}