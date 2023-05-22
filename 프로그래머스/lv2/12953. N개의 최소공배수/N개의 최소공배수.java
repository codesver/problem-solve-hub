import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        return Arrays.stream(arr)
                .reduce((lcm, num) ->
                        lcm * num / BigInteger.valueOf(lcm).gcd(BigInteger.valueOf(num)).intValue())
                .orElseThrow();
    }
}