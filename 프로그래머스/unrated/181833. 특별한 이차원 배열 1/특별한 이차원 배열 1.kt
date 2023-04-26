class Solution {
    fun solution(n: Int) = mutableListOf<IntArray>().apply {
        repeat(n) { add(IntArray(n).apply { set(it, 1) }) }
    }
}