class Solution {
    fun solution(nums: IntArray): Int = nums.fold(Pair(0, 0)) { pair, num ->
        if (num % 2 == 0) Pair(pair.first * 10 + num, pair.second)
        else Pair(pair.first, pair.second * 10 + num)
    }.let { it.first + it.second }
}