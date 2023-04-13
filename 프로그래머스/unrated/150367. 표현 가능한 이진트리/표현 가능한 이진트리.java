import java.util.Arrays;

class Solution {
    public int[] solution(long[] numbers) {
        return Arrays.stream(numbers).mapToInt(this::convert).toArray();
    }

    private int convert(long number) {
        String bits = Long.toBinaryString(number);
        int h = 0;
        while ((int) Math.pow(2, h) - 1 < bits.length()) h++;
        while ((int) Math.pow(2, h) - 1 != bits.length()) bits = 0 + bits;
        int height = (int) (Math.log(bits.length() + 1) / Math.log(2));
        return check(bits, 0, bits.length() - 1, height) ? 1 : 0;
    }

    private boolean check(String bits, int from, int to, int height) {
        if (height == 1) return true;
        int root = (from + to) / 2;
        int leftChildIndex = (from + root - 1) / 2;
        int rightChildIndex = (root + 1 + to) / 2;
        if (bits.charAt(root) == '0') {
            if (bits.charAt(leftChildIndex) == '1') return false;
            if (bits.charAt(rightChildIndex) == '1') return false;
        }
        height--;
        return check(bits, from, root - 1, height) && check(bits, root + 1, to, height);
    }
}