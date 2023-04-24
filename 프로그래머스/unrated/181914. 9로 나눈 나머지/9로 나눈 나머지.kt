class Solution {
    fun solution(number: String): Int = number.map { it.digitToInt() }.sum() % 9
}