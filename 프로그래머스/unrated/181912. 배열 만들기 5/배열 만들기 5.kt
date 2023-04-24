class Solution {
    fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int) =
        intStrs.map { it.substring(s, s + l).toInt() }.filter { it > k }.toIntArray()
}