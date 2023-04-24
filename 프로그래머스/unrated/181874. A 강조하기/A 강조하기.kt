class Solution {
    fun solution(myString: String) = 
        myString.map { if (it == 'a' || it == 'A') it.uppercase() else it.lowercase() }.joinToString("")
}