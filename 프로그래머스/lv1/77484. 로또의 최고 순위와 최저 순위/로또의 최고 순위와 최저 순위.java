class Solution {
    boolean[] nums = new boolean[46];

    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0, count = 0;

        for (int lotto : lottos)
            if (lotto == 0) zero++;
            else nums[lotto] = true;

        for (int num : win_nums) count += nums[num] ? 1 : 0;

        int rankMax = switch (count + zero) {
            case 2, 3, 4, 5, 6 -> 7 - (count + zero);
            default -> 6;
        };

        int rankMin = switch (count) {
            case 2, 3, 4, 5, 6 -> 7 - count;
            default -> 6;
        };

        return new int[]{rankMax, rankMin};
    }
}