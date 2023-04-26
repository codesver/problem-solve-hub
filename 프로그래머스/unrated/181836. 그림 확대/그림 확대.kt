class Solution {
    fun solution(picture: Array<String>, k: Int) = mutableListOf<String>().apply {
        picture.forEach { string ->
            val extended = string.map { it.toString().repeat(k) }.joinToString("")
            repeat(k) { add(extended) }
        }
    }
}