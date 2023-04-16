class Solution {
    fun solution(array: IntArray): Int = array.sumOf { it.toString().count { ch -> ch == '7' } }
}