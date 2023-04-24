class Solution {
    fun solution(nums: IntArray, n: Int) = nums.slice(n - 1 until nums.size).toIntArray()
}