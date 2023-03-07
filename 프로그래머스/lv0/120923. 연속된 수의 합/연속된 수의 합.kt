import java.util.stream.IntStream

class Solution {
    fun solution(num: Int, total: Int): IntArray {
        val start = (total - IntStream.range(0, num).sum()) / num
        return IntStream.range(start, start + num).toArray()
    }
}