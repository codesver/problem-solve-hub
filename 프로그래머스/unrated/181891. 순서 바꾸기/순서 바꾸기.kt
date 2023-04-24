class Solution {
    fun solution(nums: IntArray, n: Int) = nums.slice(n until nums.size).plus(nums.slice(0 until n))
}