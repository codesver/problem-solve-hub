import kotlin.math.max

class Solution {
    fun solution(nums: IntArray) = nums.indices.partition { it % 2 == 0 }.let { pair ->
        max(pair.first.sumOf { nums[it] }, pair.second.sumOf { nums[it] })
    }
}