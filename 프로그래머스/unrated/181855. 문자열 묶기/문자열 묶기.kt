class Solution {
    fun solution(strArr: Array<String>) = strArr.groupingBy { it.length }.eachCount().values.maxOrNull()!!
}