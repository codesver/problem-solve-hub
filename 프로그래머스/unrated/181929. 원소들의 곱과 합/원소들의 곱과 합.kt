import kotlin.math.pow

class Solution {
    fun solution(nums: IntArray): Int =
        if (nums.fold(1) {mul, num -> mul * num} < nums.sum().toDouble().pow(2)) 1 else 0
}