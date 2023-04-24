class Solution {
    fun solution(l: Int, r: Int): IntArray = (1..63)
        .map { it.toString(2).replace('1', '5').toInt() }
        .filter { it in l..r }
        .ifEmpty { listOf(-1) }
        .toIntArray()
}