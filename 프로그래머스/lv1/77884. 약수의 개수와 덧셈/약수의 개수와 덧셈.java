import java.util.stream.IntStream;

class Solution {

    private boolean isEven(int num) {
        return Math.pow((int) Math.sqrt(num), 2) != num;
    }

    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right).map(ele -> isEven(ele) ? ele : -ele).sum();
    }
}