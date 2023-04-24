class Solution {
    fun solution(arr: IntArray) =
        if (arr.contains(2)) arr.slice(arr.indexOfFirst { it == 2 }..arr.indexOfLast { it == 2 }).toList()
        else listOf(-1)
}