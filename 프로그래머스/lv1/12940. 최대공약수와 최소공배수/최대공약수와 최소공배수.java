class Solution {
    public int[] solution(int n, int m) {
        int num = 1;
        for (int i = n; i >= 1; i--)
            if (n % i == 0 && m % i == 0) {
                num = i;
                break;
            }
        return new int[]{num, n * m / num};
    }
}