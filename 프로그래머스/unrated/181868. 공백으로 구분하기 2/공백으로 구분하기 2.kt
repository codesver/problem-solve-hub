class Solution {
    fun solution(myString: String) = myString.split(Regex(" +")).filter { it.isNotEmpty() }
}