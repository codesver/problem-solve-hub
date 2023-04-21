import kotlin.math.max

class Solution {
    fun solution(a: Int, b: Int): Int = max(a.toString().plus(b).toInt(), b.toString().plus(a).toInt())
}