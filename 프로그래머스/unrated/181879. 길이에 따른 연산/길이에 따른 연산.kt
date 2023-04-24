class Solution {
    fun solution(nums: IntArray) = if (nums.size >= 11) nums.sum() else nums.fold(1) { mul, num -> mul * num }
}