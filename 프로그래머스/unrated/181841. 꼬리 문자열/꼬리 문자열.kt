class Solution {
    fun solution(strList: Array<String>, ex: String) = strList.filterNot { ex in it }.joinToString("")
}