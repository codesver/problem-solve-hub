class Solution {
    fun solution(strings: Array<String>, parts: Array<IntArray>): String = StringBuilder().apply {
        strings.indices.forEach { append(strings[it].substring(parts[it][0], parts[it][1] + 1)) }
    }.toString()
}