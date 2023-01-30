class Solution {
    public int solution(int n) {
        int m = 6;
        int div = 2;
        int mul = 1;
        while (div <= Math.min(n, m)) {
            if (n % div == 0 && m % div == 0) {
                n /= div;
                m /= div;
                mul *= div;
            } else div++;
        }
        return mul * n * m / 6;
    }
}