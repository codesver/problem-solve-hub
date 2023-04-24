class Solution {
    fun solution(nums: IntArray): Int =
        if (nums.fold(1) { mul, num -> mul * num } < nums.sum().let { it * it }) 1 else 0
}