import kotlin.math.max

class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        val size = max(arr.size, arr[0].size)
        return Array(size) { IntArray(size) }.also { array ->
            arr.forEachIndexed { row, nums -> nums.forEachIndexed { col, num -> array[row][col] = num } }
        }
    }
}