class Solution {
    fun solution(myString: String, overwriteString: String, s: Int): String =
        myString.replaceRange(s, s + overwriteString.length, overwriteString)
}