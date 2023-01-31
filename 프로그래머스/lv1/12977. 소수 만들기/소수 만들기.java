import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
        boolean[] nps = new boolean[max + 1];
        for (int p = 2; p <= max; p++)
            if (!nps[p])
                for (int n = p + p; n <= max; n += p) nps[n] = true;
        int count = 0;
        for (int a = 0; a < nums.length - 2; a++)
            for (int b = a + 1; b < nums.length - 1; b++)
                for (int c = b + 1; c < nums.length; c++)
                    if (!nps[nums[a] + nums[b] + nums[c]]) count++;
        return count;
    }
}