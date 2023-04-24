class Solution {
    fun solution(string: String, suffix: String): Int =
        if (string.length >= suffix.length && string.substring(string.length - suffix.length) == suffix) 1
        else 0
}