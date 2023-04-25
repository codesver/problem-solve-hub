class Solution {
    fun solution(arr: IntArray, k: Int) = arr.distinct().toMutableList().apply {
        if (size > k) return subList(0, k)
        else repeat(k - size) { add(-1) }
    }
}