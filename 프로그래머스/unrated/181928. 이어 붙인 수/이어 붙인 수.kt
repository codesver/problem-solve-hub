class Solution {
    fun solution(nums: IntArray): Int =
        nums.partition { it % 2 == 0 }
            .let { it.first.joinToString("").toInt() + it.second.joinToString("").toInt() }
}