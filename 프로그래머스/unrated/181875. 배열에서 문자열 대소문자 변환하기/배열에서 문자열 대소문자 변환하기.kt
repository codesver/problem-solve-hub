class Solution {
    fun solution(strArr: Array<String>) =
        strArr.mapIndexed { idx, str -> if (idx % 2 == 0) str.lowercase() else str.uppercase() }
}