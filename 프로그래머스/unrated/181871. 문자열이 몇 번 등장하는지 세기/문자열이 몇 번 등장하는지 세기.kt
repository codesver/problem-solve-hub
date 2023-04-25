class Solution {
    fun solution(myString: String, pat: String) = (0..myString.length - pat.length)
        .map { myString.substring(it, it + pat.length) }
        .count { it == pat }
}