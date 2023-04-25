class Solution {
    fun solution(strArr: Array<String>) = strArr.filter { it.contains("ad").not() }
}