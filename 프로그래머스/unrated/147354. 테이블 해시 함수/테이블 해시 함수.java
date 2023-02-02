import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int[][] table = Arrays.stream(data)
                .sorted((o1, o2) -> o1[col - 1] == o2[col - 1] ? o2[0] - o1[0] : o1[col - 1] - o2[col - 1])
                .toArray(int[][]::new);
        return IntStream.range(row_begin - 1, row_end)
                .map(r -> Arrays.stream(table[r]).map(i -> i % (r + 1)).sum())
                .reduce((x, y) -> x ^ y)
                .orElse(0);

    }
}