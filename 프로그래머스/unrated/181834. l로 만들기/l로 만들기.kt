class Solution {
    fun solution(myString: String) = myString.map { if (it < 'l') 'l' else it }.joinToString("")
}