import java.util.Arrays;

class Solution {

    public int solution(int n, int k) {
        String bits = Integer.toString(n, k);
        return (int) Arrays.stream(bits.split("0+"))
                .filter(bit -> isPrime(Long.parseLong(bit))).count();
    }

    public boolean isPrime(long num) {
        if (num == 1) return false;
        for (long div = 2; div <= Math.sqrt(num); div++)
            if (num % div == 0) return false;
        return true;
    }
}