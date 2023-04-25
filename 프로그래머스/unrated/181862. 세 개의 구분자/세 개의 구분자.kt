class Solution {
    fun solution(myStr: String) = myStr.split(Regex("[abc]+")).filterNot(String::isEmpty).ifEmpty { listOf("EMPTY") }
}