class Solution {
    fun solution(string: String): Array<String> =
        string.indices.map { string.substring(it) }.sorted().toTypedArray()
}