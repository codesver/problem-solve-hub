class Solution {
    fun solution(nums: IntArray, n: Int) = nums.slice(nums.indices step n)
}