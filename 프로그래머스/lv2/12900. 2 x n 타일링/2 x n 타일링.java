class Solution {
    public int solution(int n) {
        int i = 1;
        int[] count = {1, 2};
        while (n-- > 2) count[i = (i + 1) % 2] = (count[0] + count[1]) % 1_000_000_007;
        return count[i];
    }
}