import java.lang.RuntimeException
import kotlin.math.abs
import kotlin.math.log2
import kotlin.math.min

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int = (1..log2(n.toDouble()).toInt()).fold(Pair(a, b)) { nums, round ->
        if (abs(nums.first - nums.second) == 1 && min(nums.first, nums.second) % 2 == 1) return round
        Pair((nums.first + 1) / 2, (nums.second + 1) / 2)
    }.let { throw RuntimeException("The game is over") }
}