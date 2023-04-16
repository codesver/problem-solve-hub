import kotlin.math.min

class Solution {
    fun solution(string: String, n: Int): Array<String> =
        (string.indices step n).map { string.substring(it, min(it + n, string.length)) }.toTypedArray()
}