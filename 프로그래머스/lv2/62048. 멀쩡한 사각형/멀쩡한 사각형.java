import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
        return ((long) w * h) - (w / gcd + h / gcd - 1) * gcd;
    }
}