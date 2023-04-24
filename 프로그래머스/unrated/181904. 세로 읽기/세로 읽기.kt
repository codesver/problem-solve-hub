class Solution {
    fun solution(string: String, m: Int, c: Int) =
        (0 until string.length / m).joinToString("") { string[it * m + c - 1].toString() }
}