import java.util.stream.IntStream;

class Solution {
    public int[] solution(int num, int total) {
        int startingNumber = (total - IntStream.range(0, num).sum()) / num;
        return IntStream.range(startingNumber, startingNumber + num).toArray();
    }
}