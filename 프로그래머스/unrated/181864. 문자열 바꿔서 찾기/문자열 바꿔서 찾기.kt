class Solution {
    fun solution(myString: String, pat: String) =
        if (myString.contains(pat.replace("A", "b").replace("B", "a").uppercase())) 1
        else 0
}