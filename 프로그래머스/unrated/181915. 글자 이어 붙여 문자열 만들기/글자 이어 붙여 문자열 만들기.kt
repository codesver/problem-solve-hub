class Solution {
    fun solution(chars: String, indices: IntArray): String = indices.map { chars[it] }.joinToString("")
}