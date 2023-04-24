class Solution {
    fun solution(string: String, s: Int, e: Int) = StringBuilder().apply { 
        append(string.substring(0, s))
        append(string.substring(s, e + 1).reversed())
        append(string.substring(e + 1))
    }.toString()
}