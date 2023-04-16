class Solution {
    fun solution(myString: String): String = myString.map { Character.toLowerCase(it) }.sorted().joinToString("")
}