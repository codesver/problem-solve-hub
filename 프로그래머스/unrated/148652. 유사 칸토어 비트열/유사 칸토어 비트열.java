class Solution {
    public int solution(int n, long l, long r) {
        return countOnes("11011", 1, (long) Math.pow(5, n), l, r, n - 1);
    }

    public int countOnes(String bits, long s, long e, long l, long r, int n) {
        int sum = 0;
        if (n == 0) {
            for (long i = s; i <= e; i++)
                if (l <= i && i <= r && bits.charAt((int) (i - s)) == '1') sum++;
        } else {
            for (int i = 0; i < 5; i++) {
                String bitsTemp = bits.charAt(i) == '1' ? "11011" : "00000";
                long sTemp = s + ((e - s + 1) / 5 * i);
                long eTemp = s + ((e - s + 1) / 5 * (i + 1)) - 1;
                if (r < sTemp || l > eTemp || bitsTemp.equals("00000")) continue;
                sum += countOnes(bitsTemp, sTemp, eTemp, l, r, n - 1);
            }
        }
        return sum;
    }
}