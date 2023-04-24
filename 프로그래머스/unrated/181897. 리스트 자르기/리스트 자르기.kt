class Solution {
    fun solution(n: Int, slicer: IntArray, nums: IntArray) = when(n) {
        1 -> 0..slicer[1]
        2 -> slicer[0] until nums.size
        3 -> slicer[0]..slicer[1]
        4 -> slicer[0]..slicer[1] step slicer[2]
        else -> throw Exception("Should not reach here")
    }.map { nums[it] }
}