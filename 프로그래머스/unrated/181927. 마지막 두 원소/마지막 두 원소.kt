class Solution {
    fun solution(nums: IntArray): IntArray = nums.toMutableList().apply {
        if (last() > get(size - 2)) add(last() - get(size - 2))
        else add(last() * 2)
    }.toIntArray()
}