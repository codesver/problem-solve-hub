import java.util.Arrays;

class Solution {
    
    public long[] solution(long[] numbers) {
        return Arrays.stream(numbers).map(this::convert).toArray();
    }

    public long convert(long number) {
        StringBuilder bits = new StringBuilder("0" + Long.toString(number, 2));
        int zero = bits.lastIndexOf("0");
        int one = bits.indexOf("1", zero + 1);
        bits.setCharAt(zero, '1');
        if (one != -1) bits.setCharAt(one, '0');
        return Long.parseLong(bits.toString(), 2);
    }
}