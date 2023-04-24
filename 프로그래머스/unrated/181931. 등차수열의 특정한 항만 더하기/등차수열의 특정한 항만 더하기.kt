class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int =
        included.mapIndexed { idx, b -> if (b) a + d * idx else 0 }.sum()
}