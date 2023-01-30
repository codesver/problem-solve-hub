class Solution {
    public int[] solution(int numA, int denomA, int numB, int denomB) {
        int num = numA * denomB + numB * denomA;
        int denom = denomA * denomB;

        for (int i = 2; i <= Math.min(num, denom);) {
            if (num % i == 0 && denom % i == 0) {
                num /= i;
                denom /= i;
            } else i++;
        }
        return new int[]{num, denom};
    }
}